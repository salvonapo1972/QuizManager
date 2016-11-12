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

import it.quizscuola.portlet.model.Argomento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Argomento in entity cache.
 *
 * @author Salvatore
 * @see Argomento
 * @generated
 */
public class ArgomentoCacheModel implements CacheModel<Argomento>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", idArgomento=");
		sb.append(idArgomento);
		sb.append(", descArgomento=");
		sb.append(descArgomento);
		sb.append(", idMateria=");
		sb.append(idMateria);
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
	public Argomento toEntityModel() {
		ArgomentoImpl argomentoImpl = new ArgomentoImpl();

		if (uuid == null) {
			argomentoImpl.setUuid(StringPool.BLANK);
		}
		else {
			argomentoImpl.setUuid(uuid);
		}

		argomentoImpl.setIdArgomento(idArgomento);

		if (descArgomento == null) {
			argomentoImpl.setDescArgomento(StringPool.BLANK);
		}
		else {
			argomentoImpl.setDescArgomento(descArgomento);
		}

		argomentoImpl.setIdMateria(idMateria);
		argomentoImpl.setGroupId(groupId);
		argomentoImpl.setCompanyId(companyId);
		argomentoImpl.setUserId(userId);

		if (userName == null) {
			argomentoImpl.setUserName(StringPool.BLANK);
		}
		else {
			argomentoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			argomentoImpl.setCreateDate(null);
		}
		else {
			argomentoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			argomentoImpl.setModifiedDate(null);
		}
		else {
			argomentoImpl.setModifiedDate(new Date(modifiedDate));
		}

		argomentoImpl.resetOriginalValues();

		return argomentoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		idArgomento = objectInput.readLong();
		descArgomento = objectInput.readUTF();
		idMateria = objectInput.readLong();
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

		objectOutput.writeLong(idArgomento);

		if (descArgomento == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(descArgomento);
		}

		objectOutput.writeLong(idMateria);
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
	public long idArgomento;
	public String descArgomento;
	public long idMateria;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}