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
 * This class is used by SOAP remote services, specifically {@link it.quizscuola.portlet.service.http.RispostaUtenteServiceSoap}.
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.http.RispostaUtenteServiceSoap
 * @generated
 */
public class RispostaUtenteSoap implements Serializable {
	public static RispostaUtenteSoap toSoapModel(RispostaUtente model) {
		RispostaUtenteSoap soapModel = new RispostaUtenteSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIdRispostaUtente(model.getIdRispostaUtente());
		soapModel.setIdRisposta(model.getIdRisposta());
		soapModel.setIdUtente(model.getIdUtente());
		soapModel.setDataRisposta(model.getDataRisposta());
		soapModel.setIdDomanda(model.getIdDomanda());

		return soapModel;
	}

	public static RispostaUtenteSoap[] toSoapModels(RispostaUtente[] models) {
		RispostaUtenteSoap[] soapModels = new RispostaUtenteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RispostaUtenteSoap[][] toSoapModels(RispostaUtente[][] models) {
		RispostaUtenteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RispostaUtenteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RispostaUtenteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RispostaUtenteSoap[] toSoapModels(List<RispostaUtente> models) {
		List<RispostaUtenteSoap> soapModels = new ArrayList<RispostaUtenteSoap>(models.size());

		for (RispostaUtente model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RispostaUtenteSoap[soapModels.size()]);
	}

	public RispostaUtenteSoap() {
	}

	public long getPrimaryKey() {
		return _idRispostaUtente;
	}

	public void setPrimaryKey(long pk) {
		setIdRispostaUtente(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIdRispostaUtente() {
		return _idRispostaUtente;
	}

	public void setIdRispostaUtente(long idRispostaUtente) {
		_idRispostaUtente = idRispostaUtente;
	}

	public long getIdRisposta() {
		return _idRisposta;
	}

	public void setIdRisposta(long idRisposta) {
		_idRisposta = idRisposta;
	}

	public long getIdUtente() {
		return _idUtente;
	}

	public void setIdUtente(long idUtente) {
		_idUtente = idUtente;
	}

	public Date getDataRisposta() {
		return _dataRisposta;
	}

	public void setDataRisposta(Date dataRisposta) {
		_dataRisposta = dataRisposta;
	}

	public long getIdDomanda() {
		return _idDomanda;
	}

	public void setIdDomanda(long idDomanda) {
		_idDomanda = idDomanda;
	}

	private String _uuid;
	private long _idRispostaUtente;
	private long _idRisposta;
	private long _idUtente;
	private Date _dataRisposta;
	private long _idDomanda;
}