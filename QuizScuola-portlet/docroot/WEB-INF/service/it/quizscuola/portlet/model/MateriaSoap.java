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
 * This class is used by SOAP remote services, specifically {@link it.quizscuola.portlet.service.http.MateriaServiceSoap}.
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.http.MateriaServiceSoap
 * @generated
 */
public class MateriaSoap implements Serializable {
	public static MateriaSoap toSoapModel(Materia model) {
		MateriaSoap soapModel = new MateriaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIdMateria(model.getIdMateria());
		soapModel.setDescMateria(model.getDescMateria());
		soapModel.setIdClasse(model.getIdClasse());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static MateriaSoap[] toSoapModels(Materia[] models) {
		MateriaSoap[] soapModels = new MateriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MateriaSoap[][] toSoapModels(Materia[][] models) {
		MateriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MateriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MateriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MateriaSoap[] toSoapModels(List<Materia> models) {
		List<MateriaSoap> soapModels = new ArrayList<MateriaSoap>(models.size());

		for (Materia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MateriaSoap[soapModels.size()]);
	}

	public MateriaSoap() {
	}

	public long getPrimaryKey() {
		return _idMateria;
	}

	public void setPrimaryKey(long pk) {
		setIdMateria(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIdMateria() {
		return _idMateria;
	}

	public void setIdMateria(long idMateria) {
		_idMateria = idMateria;
	}

	public String getDescMateria() {
		return _descMateria;
	}

	public void setDescMateria(String descMateria) {
		_descMateria = descMateria;
	}

	public long getIdClasse() {
		return _idClasse;
	}

	public void setIdClasse(long idClasse) {
		_idClasse = idClasse;
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
	private long _idMateria;
	private String _descMateria;
	private long _idClasse;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}