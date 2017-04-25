package com.dbumama.market.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.dbumama.market.model.base.BaseProductCategory;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class ProductCategory extends BaseProductCategory<ProductCategory> {
	public static final ProductCategory dao = new ProductCategory();
	public static final String table = "t_product_category";
	
	/** 树路径分隔符 */
	public static final String TREE_PATH_SEPARATOR = ",";
	
	/** 下级分类 */
	private List<ProductCategory> children = new ArrayList<ProductCategory>();

	/** 商品 */
	private List<Product> products = new ArrayList<Product>();
	

	/**
	 * 查找顶级商品分类
	 * 
	 * @param count
	 *            数量
	 * @return 顶级商品分类
	 */
	public List<ProductCategory> findRoots(Integer count) {
		String sql = "SELECT * FROM t_product_category WHERE parent_id IS NULL ORDER BY orders ASC ";
		if (count != null) {
			sql += " LIMIT 0, " + count;
		}
		return find(sql);
	}
	
	
	public List<ProductCategory> find(Integer count) {
		String sql = "SELECT * FROM product_category ORDER BY RAND()";
		if (count != null) {
			sql += " LIMIT 0, " + count;
		}
		return find(sql);
	}
	
	/**
	 * 查找顶级商品分类+下级商品分类
	 * 
	 * @param count
	 *            数量
	 * @return 顶级商品分类
	 */
	public List<ProductCategory> findAll(String count) {
		String sql = "SELECT * FROM product_category WHERE orders=?";
		return find(sql, count);
	}
	/**
	 * 查找上级商品分类
	 * 
	 * @param productCategory
	 *            商品分类
	 * @param count
	 *            数量
	 * @return 上级商品分类
	 */
	public List<ProductCategory> findParents(ProductCategory productCategory, Integer count) {
		if (productCategory == null || productCategory.getParent() == null) {
			return Collections.<ProductCategory> emptyList();
		}
		String sql = "SELECT * FROM product_category productCategory WHERE productCategory.id IN (?) ORDER BY productCategory.grade ASC ";
		if (count != null) {
			sql += " LIMIT 0, " + count;
		}
		return find(sql, productCategory.getId());
	}
	
	/**
	 * 查找下级商品分类
	 * 
	 * @param productCategory
	 *            商品分类
	 * @param count
	 *            数量
	 * @return 下级商品分类
	 */
	public List<ProductCategory> findChildren(ProductCategory productCategory, Integer count) {
		String sql = null;
		if (productCategory != null) {
			sql = "SELECT * FROM product_category WHERE tree_path LIKE '%" + ProductCategory.TREE_PATH_SEPARATOR + productCategory.getId() + ProductCategory.TREE_PATH_SEPARATOR + "%' ORDER BY orders ASC ";
		} else {
			sql = "SELECT * FROM product_category ORDER BY orders ASC ";
		}
		if (count != null) {
			sql += " LIMIT 0," + count;
		}
		return find(sql);
	}
	
	/**
	 * 获取上级分类
	 * 
	 * @return 上级分类
	 */
	public ProductCategory getParent() {
		return ProductCategory.dao.findById(getParentId());
	}
	
	
	/**
	 * 获取下级分类
	 * 
	 * @return 下级分类
	 */
	public List<ProductCategory> getChildren() {
		String sql = "SELECT * FROM product_category WHERE `parent_id` = ?";
			children = ProductCategory.dao.find(sql, getId());
		return children;
	}
	
	/**
	 * 设置下级分类
	 * 
	 * @param children
	 *            下级分类
	 */
	public void setChildren(List<ProductCategory> children) {
		this.children = children;
	}
	
	/**
	 * 获取商品
	 * 
	 * @return 商品
	 */
	public List<Product> getProducts() {
		String sql = "SELECT * FROM product WHERE `product_category_id` = ?";
			products = Product.dao.find(sql, getId());
		return products;
	}
	
	/**
	 * 设置商品
	 * 
	 * @param products
	 *            商品
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
