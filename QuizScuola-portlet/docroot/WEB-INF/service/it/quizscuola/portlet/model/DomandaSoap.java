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
 * This class is used by SOAP remote services, specifically {@link it.quizscuola.portlet.service.http.DomandaServiceSoap}.
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.http.DomandaServiceSoap
 * @generated
 */
public class DomandaSoap implements Serializable {
	public static DomandaSoap toSoapModel(Domanda model) {
		DomandaSoap soapModel = new DomandaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIdDomanda(model.getIdDomanda());
		soapModel.setDescDomanda(model.getDescDomanda());
		soapModel.setIdArgomento(model.getIdArgomento());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static DomandaSoap[] toSoapModels(Domanda[] models) {
		DomandaSoap[] soapModels = new DomandaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DomandaSoap[][] toSoapModels(Domanda[][] models) {
		DomandaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DomandaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DomandaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DomandaSoap[] toSoapModels(List<Domanda> models) {
		List<DomandaSoap> soapModels = new ArrayList<DomandaSoap>(models.size());

		for (Domanda model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DomandaSoap[soapModels.size()]);
	}

	public DomandaSoap() {
	}

	public long getPrimaryKey() {
		return _idDomanda;
	}

	public void setPrimaryKey(long pk) {
		setIdDomanda(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIdDomanda() {
		return _idDomanda;
	}

	public void setIdDomanda(long idDomanda) {
		_idDomanda = idDomanda;
	}

	public String getDescDomanda() {
		return _descDomanda;
	}

	public void setDescDomanda(String descDomanda) {
		_descDomanda = descDomanda;
	}

	public long getIdArgomento() {
		return _idArgomento;
	}

	public void setIdArgomento(long idArgomento) {
		_idArgomento = idArgomento;
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
	private long _idDomanda;
	private String _descDomanda;
	private long _idArgomento;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}