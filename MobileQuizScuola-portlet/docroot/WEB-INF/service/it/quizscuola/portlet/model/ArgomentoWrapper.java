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
 * This class is a wrapper for {@link Argomento}.
 * </p>
 *
 * @author Salvatore
 * @see Argomento
 * @generated
 */
public class ArgomentoWrapper implements Argomento, ModelWrapper<Argomento> {
	public ArgomentoWrapper(Argomento argomento) {
		_argomento = argomento;
	}

	@Override
	public Class<?> getModelClass() {
		return Argomento.class;
	}

	@Override
	public String getModelClassName() {
		return Argomento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idArgomento", getIdArgomento());
		attributes.put("descArgomento", getDescArgomento());
		attributes.put("idMateria", getIdMateria());
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

		Long idArgomento = (Long)attributes.get("idArgomento");

		if (idArgomento != null) {
			setIdArgomento(idArgomento);
		}

		String descArgomento = (String)attributes.get("descArgomento");

		if (descArgomento != null) {
			setDescArgomento(descArgomento);
		}

		Long idMateria = (Long)attributes.get("idMateria");

		if (idMateria != null) {
			setIdMateria(idMateria);
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
	* Returns the primary key of this argomento.
	*
	* @return the primary key of this argomento
	*/
	@Override
	public long getPrimaryKey() {
		return _argomento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this argomento.
	*
	* @param primaryKey the primary key of this argomento
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_argomento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this argomento.
	*
	* @return the uuid of this argomento
	*/
	@Override
	public java.lang.String getUuid() {
		return _argomento.getUuid();
	}

	/**
	* Sets the uuid of this argomento.
	*
	* @param uuid the uuid of this argomento
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_argomento.setUuid(uuid);
	}

	/**
	* Returns the id argomento of this argomento.
	*
	* @return the id argomento of this argomento
	*/
	@Override
	public long getIdArgomento() {
		return _argomento.getIdArgomento();
	}

	/**
	* Sets the id argomento of this argomento.
	*
	* @param idArgomento the id argomento of this argomento
	*/
	@Override
	public void setIdArgomento(long idArgomento) {
		_argomento.setIdArgomento(idArgomento);
	}

	/**
	* Returns the desc argomento of this argomento.
	*
	* @return the desc argomento of this argomento
	*/
	@Override
	public java.lang.String getDescArgomento() {
		return _argomento.getDescArgomento();
	}

	/**
	* Sets the desc argomento of this argomento.
	*
	* @param descArgomento the desc argomento of this argomento
	*/
	@Override
	public void setDescArgomento(java.lang.String descArgomento) {
		_argomento.setDescArgomento(descArgomento);
	}

	/**
	* Returns the id materia of this argomento.
	*
	* @return the id materia of this argomento
	*/
	@Override
	public long getIdMateria() {
		return _argomento.getIdMateria();
	}

	/**
	* Sets the id materia of this argomento.
	*
	* @param idMateria the id materia of this argomento
	*/
	@Override
	public void setIdMateria(long idMateria) {
		_argomento.setIdMateria(idMateria);
	}

	/**
	* Returns the group ID of this argomento.
	*
	* @return the group ID of this argomento
	*/
	@Override
	public long getGroupId() {
		return _argomento.getGroupId();
	}

	/**
	* Sets the group ID of this argomento.
	*
	* @param groupId the group ID of this argomento
	*/
	@Override
	public void setGroupId(long groupId) {
		_argomento.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this argomento.
	*
	* @return the company ID of this argomento
	*/
	@Override
	public long getCompanyId() {
		return _argomento.getCompanyId();
	}

	/**
	* Sets the company ID of this argomento.
	*
	* @param companyId the company ID of this argomento
	*/
	@Override
	public void setCompanyId(long companyId) {
		_argomento.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this argomento.
	*
	* @return the user ID of this argomento
	*/
	@Override
	public long getUserId() {
		return _argomento.getUserId();
	}

	/**
	* Sets the user ID of this argomento.
	*
	* @param userId the user ID of this argomento
	*/
	@Override
	public void setUserId(long userId) {
		_argomento.setUserId(userId);
	}

	/**
	* Returns the user uuid of this argomento.
	*
	* @return the user uuid of this argomento
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _argomento.getUserUuid();
	}

	/**
	* Sets the user uuid of this argomento.
	*
	* @param userUuid the user uuid of this argomento
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_argomento.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this argomento.
	*
	* @return the user name of this argomento
	*/
	@Override
	public java.lang.String getUserName() {
		return _argomento.getUserName();
	}

	/**
	* Sets the user name of this argomento.
	*
	* @param userName the user name of this argomento
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_argomento.setUserName(userName);
	}

	/**
	* Returns the create date of this argomento.
	*
	* @return the create date of this argomento
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _argomento.getCreateDate();
	}

	/**
	* Sets the create date of this argomento.
	*
	* @param createDate the create date of this argomento
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_argomento.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this argomento.
	*
	* @return the modified date of this argomento
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _argomento.getModifiedDate();
	}

	/**
	* Sets the modified date of this argomento.
	*
	* @param modifiedDate the modified date of this argomento
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_argomento.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _argomento.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_argomento.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _argomento.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_argomento.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _argomento.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _argomento.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_argomento.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _argomento.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_argomento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_argomento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_argomento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ArgomentoWrapper((Argomento)_argomento.clone());
	}

	@Override
	public int compareTo(it.quizscuola.portlet.model.Argomento argomento) {
		return _argomento.compareTo(argomento);
	}

	@Override
	public int hashCode() {
		return _argomento.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.quizscuola.portlet.model.Argomento> toCacheModel() {
		return _argomento.toCacheModel();
	}

	@Override
	public it.quizscuola.portlet.model.Argomento toEscapedModel() {
		return new ArgomentoWrapper(_argomento.toEscapedModel());
	}

	@Override
	public it.quizscuola.portlet.model.Argomento toUnescapedModel() {
		return new ArgomentoWrapper(_argomento.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _argomento.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _argomento.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_argomento.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArgomentoWrapper)) {
			return false;
		}

		ArgomentoWrapper argomentoWrapper = (ArgomentoWrapper)obj;

		if (Validator.equals(_argomento, argomentoWrapper._argomento)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _argomento.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Argomento getWrappedArgomento() {
		return _argomento;
	}

	@Override
	public Argomento getWrappedModel() {
		return _argomento;
	}

	@Override
	public void resetOriginalValues() {
		_argomento.resetOriginalValues();
	}

	private Argomento _argomento;
}