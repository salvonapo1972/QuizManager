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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RispostaUtente}.
 * </p>
 *
 * @author Salvatore
 * @see RispostaUtente
 * @generated
 */
public class RispostaUtenteWrapper implements RispostaUtente,
	ModelWrapper<RispostaUtente> {
	public RispostaUtenteWrapper(RispostaUtente rispostaUtente) {
		_rispostaUtente = rispostaUtente;
	}

	@Override
	public Class<?> getModelClass() {
		return RispostaUtente.class;
	}

	@Override
	public String getModelClassName() {
		return RispostaUtente.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("idRispostaUtente", getIdRispostaUtente());
		attributes.put("idRisposta", getIdRisposta());
		attributes.put("idUtente", getIdUtente());
		attributes.put("dataRisposta", getDataRisposta());
		attributes.put("idDomanda", getIdDomanda());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long idRispostaUtente = (Long)attributes.get("idRispostaUtente");

		if (idRispostaUtente != null) {
			setIdRispostaUtente(idRispostaUtente);
		}

		Long idRisposta = (Long)attributes.get("idRisposta");

		if (idRisposta != null) {
			setIdRisposta(idRisposta);
		}

		Long idUtente = (Long)attributes.get("idUtente");

		if (idUtente != null) {
			setIdUtente(idUtente);
		}

		Date dataRisposta = (Date)attributes.get("dataRisposta");

		if (dataRisposta != null) {
			setDataRisposta(dataRisposta);
		}

		Long idDomanda = (Long)attributes.get("idDomanda");

		if (idDomanda != null) {
			setIdDomanda(idDomanda);
		}
	}

	/**
	* Returns the primary key of this risposta utente.
	*
	* @return the primary key of this risposta utente
	*/
	@Override
	public long getPrimaryKey() {
		return _rispostaUtente.getPrimaryKey();
	}

	/**
	* Sets the primary key of this risposta utente.
	*
	* @param primaryKey the primary key of this risposta utente
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rispostaUtente.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this risposta utente.
	*
	* @return the uuid of this risposta utente
	*/
	@Override
	public java.lang.String getUuid() {
		return _rispostaUtente.getUuid();
	}

	/**
	* Sets the uuid of this risposta utente.
	*
	* @param uuid the uuid of this risposta utente
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rispostaUtente.setUuid(uuid);
	}

	/**
	* Returns the id risposta utente of this risposta utente.
	*
	* @return the id risposta utente of this risposta utente
	*/
	@Override
	public long getIdRispostaUtente() {
		return _rispostaUtente.getIdRispostaUtente();
	}

	/**
	* Sets the id risposta utente of this risposta utente.
	*
	* @param idRispostaUtente the id risposta utente of this risposta utente
	*/
	@Override
	public void setIdRispostaUtente(long idRispostaUtente) {
		_rispostaUtente.setIdRispostaUtente(idRispostaUtente);
	}

	/**
	* Returns the id risposta of this risposta utente.
	*
	* @return the id risposta of this risposta utente
	*/
	@Override
	public long getIdRisposta() {
		return _rispostaUtente.getIdRisposta();
	}

	/**
	* Sets the id risposta of this risposta utente.
	*
	* @param idRisposta the id risposta of this risposta utente
	*/
	@Override
	public void setIdRisposta(long idRisposta) {
		_rispostaUtente.setIdRisposta(idRisposta);
	}

	/**
	* Returns the id utente of this risposta utente.
	*
	* @return the id utente of this risposta utente
	*/
	@Override
	public long getIdUtente() {
		return _rispostaUtente.getIdUtente();
	}

	/**
	* Sets the id utente of this risposta utente.
	*
	* @param idUtente the id utente of this risposta utente
	*/
	@Override
	public void setIdUtente(long idUtente) {
		_rispostaUtente.setIdUtente(idUtente);
	}

	/**
	* Returns the data risposta of this risposta utente.
	*
	* @return the data risposta of this risposta utente
	*/
	@Override
	public java.util.Date getDataRisposta() {
		return _rispostaUtente.getDataRisposta();
	}

	/**
	* Sets the data risposta of this risposta utente.
	*
	* @param dataRisposta the data risposta of this risposta utente
	*/
	@Override
	public void setDataRisposta(java.util.Date dataRisposta) {
		_rispostaUtente.setDataRisposta(dataRisposta);
	}

	/**
	* Returns the id domanda of this risposta utente.
	*
	* @return the id domanda of this risposta utente
	*/
	@Override
	public long getIdDomanda() {
		return _rispostaUtente.getIdDomanda();
	}

	/**
	* Sets the id domanda of this risposta utente.
	*
	* @param idDomanda the id domanda of this risposta utente
	*/
	@Override
	public void setIdDomanda(long idDomanda) {
		_rispostaUtente.setIdDomanda(idDomanda);
	}

	@Override
	public boolean isNew() {
		return _rispostaUtente.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rispostaUtente.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rispostaUtente.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rispostaUtente.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rispostaUtente.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rispostaUtente.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rispostaUtente.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rispostaUtente.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rispostaUtente.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rispostaUtente.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rispostaUtente.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RispostaUtenteWrapper((RispostaUtente)_rispostaUtente.clone());
	}

	@Override
	public int compareTo(
		it.quizscuola.portlet.model.RispostaUtente rispostaUtente) {
		return _rispostaUtente.compareTo(rispostaUtente);
	}

	@Override
	public int hashCode() {
		return _rispostaUtente.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.quizscuola.portlet.model.RispostaUtente> toCacheModel() {
		return _rispostaUtente.toCacheModel();
	}

	@Override
	public it.quizscuola.portlet.model.RispostaUtente toEscapedModel() {
		return new RispostaUtenteWrapper(_rispostaUtente.toEscapedModel());
	}

	@Override
	public it.quizscuola.portlet.model.RispostaUtente toUnescapedModel() {
		return new RispostaUtenteWrapper(_rispostaUtente.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rispostaUtente.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rispostaUtente.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rispostaUtente.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RispostaUtenteWrapper)) {
			return false;
		}

		RispostaUtenteWrapper rispostaUtenteWrapper = (RispostaUtenteWrapper)obj;

		if (Validator.equals(_rispostaUtente,
					rispostaUtenteWrapper._rispostaUtente)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RispostaUtente getWrappedRispostaUtente() {
		return _rispostaUtente;
	}

	@Override
	public RispostaUtente getWrappedModel() {
		return _rispostaUtente;
	}

	@Override
	public void resetOriginalValues() {
		_rispostaUtente.resetOriginalValues();
	}

	private RispostaUtente _rispostaUtente;
}