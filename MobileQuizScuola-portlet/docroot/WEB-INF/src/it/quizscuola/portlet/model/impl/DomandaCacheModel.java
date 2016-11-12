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

import it.quizscuola.portlet.model.Domanda;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Domanda in entity cache.
 *
 * @author Salvatore
 * @see Domanda
 * @generated
 */
public class DomandaCacheModel implements CacheModel<Domanda>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", idDomanda=");
		sb.append(idDomanda);
		sb.append(", descDomanda=");
		sb.append(descDomanda);
		sb.append(", idArgomento=");
		sb.append(idArgomento);
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
		sb.append(", posizione=");
		sb.append(posizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Domanda toEntityModel() {
		DomandaImpl domandaImpl = new DomandaImpl();

		if (uuid == null) {
			domandaImpl.setUuid(StringPool.BLANK);
		}
		else {
			domandaImpl.setUuid(uuid);
		}

		domandaImpl.setIdDomanda(idDomanda);

		if (descDomanda == null) {
			domandaImpl.setDescDomanda(StringPool.BLANK);
		}
		else {
			domandaImpl.setDescDomanda(descDomanda);
		}

		domandaImpl.setIdArgomento(idArgomento);
		domandaImpl.setGroupId(groupId);
		domandaImpl.setCompanyId(companyId);
		domandaImpl.setUserId(userId);

		if (userName == null) {
			domandaImpl.setUserName(StringPool.BLANK);
		}
		else {
			domandaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			domandaImpl.setCreateDate(null);
		}
		else {
			domandaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			domandaImpl.setModifiedDate(null);
		}
		else {
			domandaImpl.setModifiedDate(new Date(modifiedDate));
		}

		domandaImpl.setPosizione(posizione);

		domandaImpl.resetOriginalValues();

		return domandaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		idDomanda = objectInput.readLong();
		descDomanda = objectInput.readUTF();
		idArgomento = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		posizione = objectInput.readInt();
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

		objectOutput.writeLong(idDomanda);

		if (descDomanda == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descDomanda);
		}

		objectOutput.writeLong(idArgomento);
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
		objectOutput.writeInt(posizione);
	}

	public String uuid;
	public long idDomanda;
	public String descDomanda;
	public long idArgomento;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int posizione;
}