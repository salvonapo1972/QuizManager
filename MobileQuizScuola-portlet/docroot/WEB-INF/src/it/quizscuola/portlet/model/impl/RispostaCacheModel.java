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

import it.quizscuola.portlet.model.Risposta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Risposta in entity cache.
 *
 * @author Salvatore
 * @see Risposta
 * @generated
 */
public class RispostaCacheModel implements CacheModel<Risposta>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", idRisposta=");
		sb.append(idRisposta);
		sb.append(", descRisposta=");
		sb.append(descRisposta);
		sb.append(", esatta=");
		sb.append(esatta);
		sb.append(", idDomanda=");
		sb.append(idDomanda);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Risposta toEntityModel() {
		RispostaImpl rispostaImpl = new RispostaImpl();

		if (uuid == null) {
			rispostaImpl.setUuid(StringPool.BLANK);
		}
		else {
			rispostaImpl.setUuid(uuid);
		}

		rispostaImpl.setIdRisposta(idRisposta);

		if (descRisposta == null) {
			rispostaImpl.setDescRisposta(StringPool.BLANK);
		}
		else {
			rispostaImpl.setDescRisposta(descRisposta);
		}

		rispostaImpl.setEsatta(esatta);
		rispostaImpl.setIdDomanda(idDomanda);
		rispostaImpl.setGroupId(groupId);
		rispostaImpl.setCompanyId(companyId);
		rispostaImpl.setUserId(userId);

		if (userName == null) {
			rispostaImpl.setUserName(StringPool.BLANK);
		}
		else {
			rispostaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rispostaImpl.setCreateDate(null);
		}
		else {
			rispostaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rispostaImpl.setModifiedDate(null);
		}
		else {
			rispostaImpl.setModifiedDate(new Date(modifiedDate));
		}

		rispostaImpl.resetOriginalValues();

		return rispostaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		idRisposta = objectInput.readLong();
		descRisposta = objectInput.readUTF();
		esatta = objectInput.readBoolean();
		idDomanda = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(idRisposta);

		if (descRisposta == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descRisposta);
		}

		objectOutput.writeBoolean(esatta);
		objectOutput.writeLong(idDomanda);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long idRisposta;
	public String descRisposta;
	public boolean esatta;
	public long idDomanda;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}