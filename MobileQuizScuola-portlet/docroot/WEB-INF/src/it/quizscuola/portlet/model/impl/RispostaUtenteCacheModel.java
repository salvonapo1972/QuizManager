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

package it.quizscuola.portlet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.quizscuola.portlet.model.RispostaUtente;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RispostaUtente in entity cache.
 *
 * @author Salvatore
 * @see RispostaUtente
 * @generated
 */
public class RispostaUtenteCacheModel implements CacheModel<RispostaUtente>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", idRispostaUtente=");
		sb.append(idRispostaUtente);
		sb.append(", idRisposta=");
		sb.append(idRisposta);
		sb.append(", idUtente=");
		sb.append(idUtente);
		sb.append(", dataRisposta=");
		sb.append(dataRisposta);
		sb.append(", idDomanda=");
		sb.append(idDomanda);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RispostaUtente toEntityModel() {
		RispostaUtenteImpl rispostaUtenteImpl = new RispostaUtenteImpl();

		if (uuid == null) {
			rispostaUtenteImpl.setUuid(StringPool.BLANK);
		}
		else {
			rispostaUtenteImpl.setUuid(uuid);
		}

		rispostaUtenteImpl.setIdRispostaUtente(idRispostaUtente);
		rispostaUtenteImpl.setIdRisposta(idRisposta);
		rispostaUtenteImpl.setIdUtente(idUtente);

		if (dataRisposta == Long.MIN_VALUE) {
			rispostaUtenteImpl.setDataRisposta(null);
		}
		else {
			rispostaUtenteImpl.setDataRisposta(new Date(dataRisposta));
		}

		rispostaUtenteImpl.setIdDomanda(idDomanda);

		rispostaUtenteImpl.resetOriginalValues();

		return rispostaUtenteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		idRispostaUtente = objectInput.readLong();
		idRisposta = objectInput.readLong();
		idUtente = objectInput.readLong();
		dataRisposta = objectInput.readLong();
		idDomanda = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(idRispostaUtente);
		objectOutput.writeLong(idRisposta);
		objectOutput.writeLong(idUtente);
		objectOutput.writeLong(dataRisposta);
		objectOutput.writeLong(idDomanda);
	}

	public String uuid;
	public long idRispostaUtente;
	public long idRisposta;
	public long idUtente;
	public long dataRisposta;
	public long idDomanda;
}