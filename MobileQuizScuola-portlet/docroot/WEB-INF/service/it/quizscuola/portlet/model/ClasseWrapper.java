/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.quizscuola.portlet.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Classe}.
 * </p>
 *
 * @author Salvatore
 * @see Classe
 * @generated
 */
public class ClasseWrapper implements Classe, ModelWrapper<Classe> {
	public ClasseWrapper(Classe classe) {
		_classe = classe;
	}

	@Override
	public Class<?> getModelClass() {
		return Classe.class;
	}

	@Override
	public String getModelClassName() {
		return Classe.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("descClasse", getDescClasse());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descClasse = (String)attributes.get("descClasse");

		if (descClasse != null) {
			setDescClasse(descClasse);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this classe.
	*
	* @return the primary key of this classe
	*/
	@Override
	public long getPrimaryKey() {
		return _classe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this classe.
	*
	* @param primaryKey the primary key of this classe
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_classe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this classe.
	*
	* @return the uuid of this classe
	*/
	@Override
	public java.lang.String getUuid() {
		return _classe.getUuid();
	}

	/**
	* Sets the uuid of this classe.
	*
	* @param uuid the uuid of this classe
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_classe.setUuid(uuid);
	}

	/**
	* Returns the ID of this classe.
	*
	* @return the ID of this classe
	*/
	@Override
	public long getId() {
		return _classe.getId();
	}

	/**
	* Sets the ID of this classe.
	*
	* @param id the ID of this classe
	*/
	@Override
	public void setId(long id) {
		_classe.setId(id);
	}

	/**
	* Returns the desc classe of this classe.
	*
	* @return the desc classe of this classe
	*/
	@Override
	public java.lang.String getDescClasse() {
		return _classe.getDescClasse();
	}

	/**
	* Sets the desc classe of this classe.
	*
	* @param descClasse the desc classe of this classe
	*/
	@Override
	public void setDescClasse(java.lang.String descClasse) {
		_classe.setDescClasse(descClasse);
	}

	/**
	* Returns the group ID of this classe.
	*
	* @return the group ID of this classe
	*/
	@Override
	public long getGroupId() {
		return _classe.getGroupId();
	}

	/**
	* Sets the group ID of this classe.
	*
	* @param groupId the group ID of this classe
	*/
	@Override
	public void setGroupId(long groupId) {
		_classe.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this classe.
	*
	* @return the company ID of this classe
	*/
	@Override
	public long getCompanyId() {
		return _classe.getCompanyId();
	}

	/**
	* Sets the company ID of this classe.
	*
	* @param companyId the company ID of this classe
	*/
	@Override
	public void setCompanyId(long companyId) {
		_classe.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this classe.
	*
	* @return the user ID of this classe
	*/
	@Override
	public long getUserId() {
		return _classe.getUserId();
	}

	/**
	* Sets the user ID of this classe.
	*
	* @param userId the user ID of this classe
	*/
	@Override
	public void setUserId(long userId) {
		_classe.setUserId(userId);
	}

	/**
	* Returns the user uuid of this classe.
	*
	* @return the user uuid of this classe
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _classe.getUserUuid();
	}

	/**
	* Sets the user uuid of this classe.
	*
	* @param userUuid the user uuid of this classe
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_classe.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this classe.
	*
	* @return the user name of this classe
	*/
	@Override
	public java.lang.String getUserName() {
		return _classe.getUserName();
	}

	/**
	* Sets the user name of this classe.
	*
	* @param userName the user name of this classe
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_classe.setUserName(userName);
	}

	/**
	* Returns the create date of this classe.
	*
	* @return the create date of this classe
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _classe.getCreateDate();
	}

	/**
	* Sets the create date of this classe.
	*
	* @param createDate the create date of this classe
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_classe.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this classe.
	*
	* @return the modified date of this classe
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _classe.getModifiedDate();
	}

	/**
	* Sets the modified date of this classe.
	*
	* @param modifiedDate the modified date of this classe
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_classe.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _classe.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_classe.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _classe.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_classe.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _classe.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _classe.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_classe.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _classe.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_classe.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_classe.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_classe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ClasseWrapper((Classe)_classe.clone());
	}

	@Override
	public int compareTo(it.quizscuola.portlet.model.Classe classe) {
		return _classe.compareTo(classe);
	}

	@Override
	public int hashCode() {
		return _classe.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.quizscuola.portlet.model.Classe> toCacheModel() {
		return _classe.toCacheModel();
	}

	@Override
	public it.quizscuola.portlet.model.Classe toEscapedModel() {
		return new ClasseWrapper(_classe.toEscapedModel());
	}

	@Override
	public it.quizscuola.portlet.model.Classe toUnescapedModel() {
		return new ClasseWrapper(_classe.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _classe.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _classe.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_classe.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClasseWrapper)) {
			return false;
		}

		ClasseWrapper classeWrapper = (ClasseWrapper)obj;

		if (Validator.equals(_classe, classeWrapper._classe)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _classe.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Classe getWrappedClasse() {
		return _classe;
	}

	@Override
	public Classe getWrappedModel() {
		return _classe;
	}

	@Override
	public void resetOriginalValues() {
		_classe.resetOriginalValues();
	}

	private Classe _classe;
}