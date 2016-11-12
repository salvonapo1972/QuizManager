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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.quizscuola.portlet.service.http.RispostaServiceSoap}.
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.http.RispostaServiceSoap
 * @generated
 */
public class RispostaSoap implements Serializable {
	public static RispostaSoap toSoapModel(Risposta model) {
		RispostaSoap soapModel = new RispostaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIdRisposta(model.getIdRisposta());
		soapModel.setDescRisposta(model.getDescRisposta());
		soapModel.setPosizione(model.getPosizione());
		soapModel.setEsatta(model.getEsatta());
		soapModel.setIdDomanda(model.getIdDomanda());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static RispostaSoap[] toSoapModels(Risposta[] models) {
		RispostaSoap[] soapModels = new RispostaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RispostaSoap[][] toSoapModels(Risposta[][] models) {
		RispostaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RispostaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RispostaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RispostaSoap[] toSoapModels(List<Risposta> models) {
		List<RispostaSoap> soapModels = new ArrayList<RispostaSoap>(models.size());

		for (Risposta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RispostaSoap[soapModels.size()]);
	}

	public RispostaSoap() {
	}

	public long getPrimaryKey() {
		return _idRisposta;
	}

	public void setPrimaryKey(long pk) {
		setIdRisposta(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIdRisposta() {
		return _idRisposta;
	}

	public void setIdRisposta(long idRisposta) {
		_idRisposta = idRisposta;
	}

	public String getDescRisposta() {
		return _descRisposta;
	}

	public void setDescRisposta(String descRisposta) {
		_descRisposta = descRisposta;
	}

	public int getPosizione() {
		return _posizione;
	}

	public void setPosizione(int posizione) {
		_posizione = posizione;
	}

	public boolean getEsatta() {
		return _esatta;
	}

	public boolean isEsatta() {
		return _esatta;
	}

	public void setEsatta(boolean esatta) {
		_esatta = esatta;
	}

	public long getIdDomanda() {
		return _idDomanda;
	}

	public void setIdDomanda(long idDomanda) {
		_idDomanda = idDomanda;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _idRisposta;
	private String _descRisposta;
	private int _posizione;
	private boolean _esatta;
	private long _idDomanda;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}