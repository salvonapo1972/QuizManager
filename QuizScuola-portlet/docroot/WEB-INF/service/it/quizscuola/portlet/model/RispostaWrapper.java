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
 * This class is a wrapper for {@link Risposta}.
 * </p>
 *
 * @author Salvatore
 * @see Risposta
 * @generated
 */
public class RispostaWrapper implements Risposta, ModelWrapper<Risposta> {
	public RispostaWrapper(Risposta risposta) {
		_risposta = risposta;
	}

	@Override
	public Class<?> getModelClass() {
		return Risposta.class;
	}

	@Override
	public String getModelClassName() {
		return Risposta.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idRisposta", getIdRisposta());
		attributes.put("descRisposta", getDescRisposta());
		attributes.put("posizione", getPosizione());
		attributes.put("esatta", getEsatta());
		attributes.put("idDomanda", getIdDomanda());
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

		Long idRisposta = (Long)attributes.get("idRisposta");

		if (idRisposta != null) {
			setIdRisposta(idRisposta);
		}

		String descRisposta = (String)attributes.get("descRisposta");

		if (descRisposta != null) {
			setDescRisposta(descRisposta);
		}

		Integer posizione = (Integer)attributes.get("posizione");

		if (posizione != null) {
			setPosizione(posizione);
		}

		Boolean esatta = (Boolean)attributes.get("esatta");

		if (esatta != null) {
			setEsatta(esatta);
		}

		Long idDomanda = (Long)attributes.get("idDomanda");

		if (idDomanda != null) {
			setIdDomanda(idDomanda);
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
	* Returns the primary key of this risposta.
	*
	* @return the primary key of this risposta
	*/
	@Override
	public long getPrimaryKey() {
		return _risposta.getPrimaryKey();
	}

	/**
	* Sets the primary key of this risposta.
	*
	* @param primaryKey the primary key of this risposta
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_risposta.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this risposta.
	*
	* @return the uuid of this risposta
	*/
	@Override
	public java.lang.String getUuid() {
		return _risposta.getUuid();
	}

	/**
	* Sets the uuid of this risposta.
	*
	* @param uuid the uuid of this risposta
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_risposta.setUuid(uuid);
	}

	/**
	* Returns the id risposta of this risposta.
	*
	* @return the id risposta of this risposta
	*/
	@Override
	public long getIdRisposta() {
		return _risposta.getIdRisposta();
	}

	/**
	* Sets the id risposta of this risposta.
	*
	* @param idRisposta the id risposta of this risposta
	*/
	@Override
	public void setIdRisposta(long idRisposta) {
		_risposta.setIdRisposta(idRisposta);
	}

	/**
	* Returns the desc risposta of this risposta.
	*
	* @return the desc risposta of this risposta
	*/
	@Override
	public java.lang.String getDescRisposta() {
		return _risposta.getDescRisposta();
	}

	/**
	* Sets the desc risposta of this risposta.
	*
	* @param descRisposta the desc risposta of this risposta
	*/
	@Override
	public void setDescRisposta(java.lang.String descRisposta) {
		_risposta.setDescRisposta(descRisposta);
	}

	/**
	* Returns the posizione of this risposta.
	*
	* @return the posizione of this risposta
	*/
	@Override
	public int getPosizione() {
		return _risposta.getPosizione();
	}

	/**
	* Sets the posizione of this risposta.
	*
	* @param posizione the posizione of this risposta
	*/
	@Override
	public void setPosizione(int posizione) {
		_risposta.setPosizione(posizione);
	}

	/**
	* Returns the esatta of this risposta.
	*
	* @return the esatta of this risposta
	*/
	@Override
	public boolean getEsatta() {
		return _risposta.getEsatta();
	}

	/**
	* Returns <code>true</code> if this risposta is esatta.
	*
	* @return <code>true</code> if this risposta is esatta; <code>false</code> otherwise
	*/
	@Override
	public boolean isEsatta() {
		return _risposta.isEsatta();
	}

	/**
	* Sets whether this risposta is esatta.
	*
	* @param esatta the esatta of this risposta
	*/
	@Override
	public void setEsatta(boolean esatta) {
		_risposta.setEsatta(esatta);
	}

	/**
	* Returns the id domanda of this risposta.
	*
	* @return the id domanda of this risposta
	*/
	@Override
	public long getIdDomanda() {
		return _risposta.getIdDomanda();
	}

	/**
	* Sets the id domanda of this risposta.
	*
	* @param idDomanda the id domanda of this risposta
	*/
	@Override
	public void setIdDomanda(long idDomanda) {
		_risposta.setIdDomanda(idDomanda);
	}

	/**
	* Returns the group ID of this risposta.
	*
	* @return the group ID of this risposta
	*/
	@Override
	public long getGroupId() {
		return _risposta.getGroupId();
	}

	/**
	* Sets the group ID of this risposta.
	*
	* @param groupId the group ID of this risposta
	*/
	@Override
	public void setGroupId(long groupId) {
		_risposta.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this risposta.
	*
	* @return the company ID of this risposta
	*/
	@Override
	public long getCompanyId() {
		return _risposta.getCompanyId();
	}

	/**
	* Sets the company ID of this risposta.
	*
	* @param companyId the company ID of this risposta
	*/
	@Override
	public void setCompanyId(long companyId) {
		_risposta.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this risposta.
	*
	* @return the user ID of this risposta
	*/
	@Override
	public long getUserId() {
		return _risposta.getUserId();
	}

	/**
	* Sets the user ID of this risposta.
	*
	* @param userId the user ID of this risposta
	*/
	@Override
	public void setUserId(long userId) {
		_risposta.setUserId(userId);
	}

	/**
	* Returns the user uuid of this risposta.
	*
	* @return the user uuid of this risposta
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _risposta.getUserUuid();
	}

	/**
	* Sets the user uuid of this risposta.
	*
	* @param userUuid the user uuid of this risposta
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_risposta.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this risposta.
	*
	* @return the user name of this risposta
	*/
	@Override
	public java.lang.String getUserName() {
		return _risposta.getUserName();
	}

	/**
	* Sets the user name of this risposta.
	*
	* @param userName the user name of this risposta
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_risposta.setUserName(userName);
	}

	/**
	* Returns the create date of this risposta.
	*
	* @return the create date of this risposta
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _risposta.getCreateDate();
	}

	/**
	* Sets the create date of this risposta.
	*
	* @param createDate the create date of this risposta
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_risposta.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this risposta.
	*
	* @return the modified date of this risposta
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _risposta.getModifiedDate();
	}

	/**
	* Sets the modified date of this risposta.
	*
	* @param modifiedDate the modified date of this risposta
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_risposta.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _risposta.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_risposta.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _risposta.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_risposta.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _risposta.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _risposta.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_risposta.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _risposta.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_risposta.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_risposta.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_risposta.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RispostaWrapper((Risposta)_risposta.clone());
	}

	@Override
	public int compareTo(it.quizscuola.portlet.model.Risposta risposta) {
		return _risposta.compareTo(risposta);
	}

	@Override
	public int hashCode() {
		return _risposta.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.quizscuola.portlet.model.Risposta> toCacheModel() {
		return _risposta.toCacheModel();
	}

	@Override
	public it.quizscuola.portlet.model.Risposta toEscapedModel() {
		return new RispostaWrapper(_risposta.toEscapedModel());
	}

	@Override
	public it.quizscuola.portlet.model.Risposta toUnescapedModel() {
		return new RispostaWrapper(_risposta.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _risposta.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _risposta.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_risposta.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RispostaWrapper)) {
			return false;
		}

		RispostaWrapper rispostaWrapper = (RispostaWrapper)obj;

		if (Validator.equals(_risposta, rispostaWrapper._risposta)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _risposta.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Risposta getWrappedRisposta() {
		return _risposta;
	}

	@Override
	public Risposta getWrappedModel() {
		return _risposta;
	}

	@Override
	public void resetOriginalValues() {
		_risposta.resetOriginalValues();
	}

	private Risposta _risposta;
}