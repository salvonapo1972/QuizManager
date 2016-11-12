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
 * This class is a wrapper for {@link Materia}.
 * </p>
 *
 * @author Salvatore
 * @see Materia
 * @generated
 */
public class MateriaWrapper implements Materia, ModelWrapper<Materia> {
	public MateriaWrapper(Materia materia) {
		_materia = materia;
	}

	@Override
	public Class<?> getModelClass() {
		return Materia.class;
	}

	@Override
	public String getModelClassName() {
		return Materia.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idMateria", getIdMateria());
		attributes.put("descMateria", getDescMateria());
		attributes.put("idClasse", getIdClasse());
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

		Long idMateria = (Long)attributes.get("idMateria");

		if (idMateria != null) {
			setIdMateria(idMateria);
		}

		String descMateria = (String)attributes.get("descMateria");

		if (descMateria != null) {
			setDescMateria(descMateria);
		}

		Long idClasse = (Long)attributes.get("idClasse");

		if (idClasse != null) {
			setIdClasse(idClasse);
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
	* Returns the primary key of this materia.
	*
	* @return the primary key of this materia
	*/
	@Override
	public long getPrimaryKey() {
		return _materia.getPrimaryKey();
	}

	/**
	* Sets the primary key of this materia.
	*
	* @param primaryKey the primary key of this materia
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_materia.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this materia.
	*
	* @return the uuid of this materia
	*/
	@Override
	public java.lang.String getUuid() {
		return _materia.getUuid();
	}

	/**
	* Sets the uuid of this materia.
	*
	* @param uuid the uuid of this materia
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_materia.setUuid(uuid);
	}

	/**
	* Returns the id materia of this materia.
	*
	* @return the id materia of this materia
	*/
	@Override
	public long getIdMateria() {
		return _materia.getIdMateria();
	}

	/**
	* Sets the id materia of this materia.
	*
	* @param idMateria the id materia of this materia
	*/
	@Override
	public void setIdMateria(long idMateria) {
		_materia.setIdMateria(idMateria);
	}

	/**
	* Returns the desc materia of this materia.
	*
	* @return the desc materia of this materia
	*/
	@Override
	public java.lang.String getDescMateria() {
		return _materia.getDescMateria();
	}

	/**
	* Sets the desc materia of this materia.
	*
	* @param descMateria the desc materia of this materia
	*/
	@Override
	public void setDescMateria(java.lang.String descMateria) {
		_materia.setDescMateria(descMateria);
	}

	/**
	* Returns the id classe of this materia.
	*
	* @return the id classe of this materia
	*/
	@Override
	public long getIdClasse() {
		return _materia.getIdClasse();
	}

	/**
	* Sets the id classe of this materia.
	*
	* @param idClasse the id classe of this materia
	*/
	@Override
	public void setIdClasse(long idClasse) {
		_materia.setIdClasse(idClasse);
	}

	/**
	* Returns the group ID of this materia.
	*
	* @return the group ID of this materia
	*/
	@Override
	public long getGroupId() {
		return _materia.getGroupId();
	}

	/**
	* Sets the group ID of this materia.
	*
	* @param groupId the group ID of this materia
	*/
	@Override
	public void setGroupId(long groupId) {
		_materia.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this materia.
	*
	* @return the company ID of this materia
	*/
	@Override
	public long getCompanyId() {
		return _materia.getCompanyId();
	}

	/**
	* Sets the company ID of this materia.
	*
	* @param companyId the company ID of this materia
	*/
	@Override
	public void setCompanyId(long companyId) {
		_materia.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this materia.
	*
	* @return the user ID of this materia
	*/
	@Override
	public long getUserId() {
		return _materia.getUserId();
	}

	/**
	* Sets the user ID of this materia.
	*
	* @param userId the user ID of this materia
	*/
	@Override
	public void setUserId(long userId) {
		_materia.setUserId(userId);
	}

	/**
	* Returns the user uuid of this materia.
	*
	* @return the user uuid of this materia
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _materia.getUserUuid();
	}

	/**
	* Sets the user uuid of this materia.
	*
	* @param userUuid the user uuid of this materia
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_materia.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this materia.
	*
	* @return the user name of this materia
	*/
	@Override
	public java.lang.String getUserName() {
		return _materia.getUserName();
	}

	/**
	* Sets the user name of this materia.
	*
	* @param userName the user name of this materia
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_materia.setUserName(userName);
	}

	/**
	* Returns the create date of this materia.
	*
	* @return the create date of this materia
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _materia.getCreateDate();
	}

	/**
	* Sets the create date of this materia.
	*
	* @param createDate the create date of this materia
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_materia.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this materia.
	*
	* @return the modified date of this materia
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _materia.getModifiedDate();
	}

	/**
	* Sets the modified date of this materia.
	*
	* @param modifiedDate the modified date of this materia
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_materia.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _materia.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_materia.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _materia.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_materia.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _materia.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _materia.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_materia.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _materia.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_materia.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_materia.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_materia.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MateriaWrapper((Materia)_materia.clone());
	}

	@Override
	public int compareTo(it.quizscuola.portlet.model.Materia materia) {
		return _materia.compareTo(materia);
	}

	@Override
	public int hashCode() {
		return _materia.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.quizscuola.portlet.model.Materia> toCacheModel() {
		return _materia.toCacheModel();
	}

	@Override
	public it.quizscuola.portlet.model.Materia toEscapedModel() {
		return new MateriaWrapper(_materia.toEscapedModel());
	}

	@Override
	public it.quizscuola.portlet.model.Materia toUnescapedModel() {
		return new MateriaWrapper(_materia.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _materia.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _materia.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_materia.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MateriaWrapper)) {
			return false;
		}

		MateriaWrapper materiaWrapper = (MateriaWrapper)obj;

		if (Validator.equals(_materia, materiaWrapper._materia)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _materia.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Materia getWrappedMateria() {
		return _materia;
	}

	@Override
	public Materia getWrappedModel() {
		return _materia;
	}

	@Override
	public void resetOriginalValues() {
		_materia.resetOriginalValues();
	}

	private Materia _materia;
}