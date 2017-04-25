package com.dbumama.market.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePurchase<M extends BasePurchase<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setDesc(java.lang.String desc) {
		set("desc", desc);
	}

	public java.lang.String getDesc() {
		return get("desc");
	}

	public void setExpiresIn(java.lang.Integer expiresIn) {
		set("expires_in", expiresIn);
	}

	public java.lang.Integer getExpiresIn() {
		return get("expires_in");
	}

	public void setPayFee(java.lang.Double payFee) {
		set("pay_fee", payFee);
	}

	public java.lang.Double getPayFee() {
		return get("pay_fee");
	}

	public void setIsDefault(java.lang.Integer isDefault) {
		set("is_default", isDefault);
	}

	public java.lang.Integer getIsDefault() {
		return get("is_default");
	}

	public void setStatus(java.lang.Integer status) {
		set("status", status);
	}

	public java.lang.Integer getStatus() {
		return get("status");
	}

	public void setCreated(java.util.Date created) {
		set("created", created);
	}

	public java.util.Date getCreated() {
		return get("created");
	}

	public void setUpdated(java.util.Date updated) {
		set("updated", updated);
	}

	public java.util.Date getUpdated() {
		return get("updated");
	}

}
