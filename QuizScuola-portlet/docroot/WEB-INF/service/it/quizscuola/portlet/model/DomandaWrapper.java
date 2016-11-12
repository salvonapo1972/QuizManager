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
 * This class is a wrapper for {@link Domanda}.
 * </p>
 *
 * @author Salvatore
 * @see Domanda
 * @generated
 */
public class DomandaWrapper implements Domanda, ModelWrapper<Domanda> {
	public DomandaWrapper(Domanda domanda) {
		_domanda = domanda;
	}

	@Override
	public Class<?> getModelClass() {
		return Domanda.class;
	}

	@Override
	public String getModelClassName() {
		return Domanda.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idDomanda", getIdDomanda());
		attributes.put("descDomanda", getDescDomanda());
		attributes.put("idArgomento", getIdArgomento());
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

		Long idDomanda = (Long)attributes.get("idDomanda");

		if (idDomanda != null) {
			setIdDomanda(idDomanda);
		}

		String descDomanda = (String)attributes.get("descDomanda");

		if (descDomanda != null) {
			setDescDomanda(descDomanda);
		}

		Long idArgomento = (Long)attributes.get("idArgomento");

		if (idArgomento != null) {
			setIdArgomento(idArgomento);
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
	* Returns the primary key of this domanda.
	*
	* @return the primary key of this domanda
	*/
	@Override
	public long getPrimaryKey() {
		return _domanda.getPrimaryKey();
	}

	/**
	* Sets the primary key of this domanda.
	*
	* @param primaryKey the primary key of this domanda
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_domanda.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this domanda.
	*
	* @return the uuid of this domanda
	*/
	@Override
	public java.lang.String getUuid() {
		return _domanda.getUuid();
	}

	/**
	* Sets the uuid of this domanda.
	*
	* @param uuid the uuid of this domanda
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_domanda.setUuid(uuid);
	}

	/**
	* Returns the id domanda of this domanda.
	*
	* @return the id domanda of this domanda
	*/
	@Override
	public long getIdDomanda() {
		return _domanda.getIdDomanda();
	}

	/**
	* Sets the id domanda of this domanda.
	*
	* @param idDomanda the id domanda of this domanda
	*/
	@Override
	public void setIdDomanda(long idDomanda) {
		_domanda.setIdDomanda(idDomanda);
	}

	/**
	* Returns the desc domanda of this domanda.
	*
	* @return the desc domanda of this domanda
	*/
	@Override
	public java.lang.String getDescDomanda() {
		return _domanda.getDescDomanda();
	}

	/**
	* Sets the desc domanda of this domanda.
	*
	* @param descDomanda the desc domanda of this domanda
	*/
	@Override
	public void setDescDomanda(java.lang.String descDomanda) {
		_domanda.setDescDomanda(descDomanda);
	}

	/**
	* Returns the id argomento of this domanda.
	*
	* @return the id argomento of this domanda
	*/
	@Override
	public long getIdArgomento() {
		return _domanda.getIdArgomento();
	}

	/**
	* Sets the id argomento of this domanda.
	*
	* @param idArgomento the id argomento of this domanda
	*/
	@Override
	public void setIdArgomento(long idArgomento) {
		_domanda.setIdArgomento(idArgomento);
	}

	/**
	* Returns the group ID of this domanda.
	*
	* @return the group ID of this domanda
	*/
	@Override
	public long getGroupId() {
		return _domanda.getGroupId();
	}

	/**
	* Sets the group ID of this domanda.
	*
	* @param groupId the group ID of this domanda
	*/
	@Override
	public void setGroupId(long groupId) {
		_domanda.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this domanda.
	*
	* @return the company ID of this domanda
	*/
	@Override
	public long getCompanyId() {
		return _domanda.getCompanyId();
	}

	/**
	* Sets the company ID of this domanda.
	*
	* @param companyId the company ID of this domanda
	*/
	@Override
	public void setCompanyId(long companyId) {
		_domanda.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this domanda.
	*
	* @return the user ID of this domanda
	*/
	@Override
	public long getUserId() {
		return _domanda.getUserId();
	}

	/**
	* Sets the user ID of this domanda.
	*
	* @param userId the user ID of this domanda
	*/
	@Override
	public void setUserId(long userId) {
		_domanda.setUserId(userId);
	}

	/**
	* Returns the user uuid of this domanda.
	*
	* @return the user uuid of this domanda
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _domanda.getUserUuid();
	}

	/**
	* Sets the user uuid of this domanda.
	*
	* @param userUuid the user uuid of this domanda
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_domanda.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this domanda.
	*
	* @return the user name of this domanda
	*/
	@Override
	public java.lang.String getUserName() {
		return _domanda.getUserName();
	}

	/**
	* Sets the user name of this domanda.
	*
	* @param userName the user name of this domanda
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_domanda.setUserName(userName);
	}

	/**
	* Returns the create date of this domanda.
	*
	* @return the create date of this domanda
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _domanda.getCreateDate();
	}

	/**
	* Sets the create date of this domanda.
	*
	* @param createDate the create date of this domanda
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_domanda.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this domanda.
	*
	* @return the modified date of this domanda
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _domanda.getModifiedDate();
	}

	/**
	* Sets the modified date of this domanda.
	*
	* @param modifiedDate the modified date of this domanda
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_domanda.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _domanda.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_domanda.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _domanda.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_domanda.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _domanda.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _domanda.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_domanda.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _domanda.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_domanda.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_domanda.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_domanda.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DomandaWrapper((Domanda)_domanda.clone());
	}

	@Override
	public int compareTo(it.quizscuola.portlet.model.Domanda domanda) {
		return _domanda.compareTo(domanda);
	}

	@Override
	public int hashCode() {
		return _domanda.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.quizscuola.portlet.model.Domanda> toCacheModel() {
		return _domanda.toCacheModel();
	}

	@Override
	public it.quizscuola.portlet.model.Domanda toEscapedModel() {
		return new DomandaWrapper(_domanda.toEscapedModel());
	}

	@Override
	public it.quizscuola.portlet.model.Domanda toUnescapedModel() {
		return new DomandaWrapper(_domanda.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _domanda.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _domanda.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_domanda.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DomandaWrapper)) {
			return false;
		}

		DomandaWrapper domandaWrapper = (DomandaWrapper)obj;

		if (Validator.equals(_domanda, domandaWrapper._domanda)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _domanda.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Domanda getWrappedDomanda() {
		return _domanda;
	}

	@Override
	public Domanda getWrappedModel() {
		return _domanda;
	}

	@Override
	public void resetOriginalValues() {
		_domanda.resetOriginalValues();
	}

	private Domanda _domanda;
}