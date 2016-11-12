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

package it.quizscuola.portlet.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import it.quizscuola.portlet.model.RispostaUtente;
import it.quizscuola.portlet.service.RispostaUtenteLocalService;
import it.quizscuola.portlet.service.persistence.ArgomentoPersistence;
import it.quizscuola.portlet.service.persistence.ClassePersistence;
import it.quizscuola.portlet.service.persistence.DomandaPersistence;
import it.quizscuola.portlet.service.persistence.MateriaPersistence;
import it.quizscuola.portlet.service.persistence.RispostaPersistence;
import it.quizscuola.portlet.service.persistence.RispostaUtentePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the risposta utente local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.quizscuola.portlet.service.impl.RispostaUtenteLocalServiceImpl}.
 * </p>
 *
 * @author Salvatore
 * @see it.quizscuola.portlet.service.impl.RispostaUtenteLocalServiceImpl
 * @see it.quizscuola.portlet.service.RispostaUtenteLocalServiceUtil
 * @generated
 */
public abstract class RispostaUtenteLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements RispostaUtenteLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.quizscuola.portlet.service.RispostaUtenteLocalServiceUtil} to access the risposta utente local service.
	 */

	/**
	 * Adds the risposta utente to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rispostaUtente the risposta utente
	 * @return the risposta utente that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RispostaUtente addRispostaUtente(RispostaUtente rispostaUtente)
		throws SystemException {
		rispostaUtente.setNew(true);

		return rispostaUtentePersistence.update(rispostaUtente);
	}

	/**
	 * Creates a new risposta utente with the primary key. Does not add the risposta utente to the database.
	 *
	 * @param idRispostaUtente the primary key for the new risposta utente
	 * @return the new risposta utente
	 */
	@Override
	public RispostaUtente createRispostaUtente(long idRispostaUtente) {
		return rispostaUtentePersistence.create(idRispostaUtente);
	}

	/**
	 * Deletes the risposta utente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idRispostaUtente the primary key of the risposta utente
	 * @return the risposta utente that was removed
	 * @throws PortalException if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RispostaUtente deleteRispostaUtente(long idRispostaUtente)
		throws PortalException, SystemException {
		return rispostaUtentePersistence.remove(idRispostaUtente);
	}

	/**
	 * Deletes the risposta utente from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rispostaUtente the risposta utente
	 * @return the risposta utente that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RispostaUtente deleteRispostaUtente(RispostaUtente rispostaUtente)
		throws SystemException {
		return rispostaUtentePersistence.remove(rispostaUtente);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(RispostaUtente.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return rispostaUtentePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return rispostaUtentePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return rispostaUtentePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return rispostaUtentePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return rispostaUtentePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public RispostaUtente fetchRispostaUtente(long idRispostaUtente)
		throws SystemException {
		return rispostaUtentePersistence.fetchByPrimaryKey(idRispostaUtente);
	}

	/**
	 * Returns the risposta utente with the primary key.
	 *
	 * @param idRispostaUtente the primary key of the risposta utente
	 * @return the risposta utente
	 * @throws PortalException if a risposta utente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RispostaUtente getRispostaUtente(long idRispostaUtente)
		throws PortalException, SystemException {
		return rispostaUtentePersistence.findByPrimaryKey(idRispostaUtente);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return rispostaUtentePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the risposta utentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.RispostaUtenteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of risposta utentes
	 * @param end the upper bound of the range of risposta utentes (not inclusive)
	 * @return the range of risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RispostaUtente> getRispostaUtentes(int start, int end)
		throws SystemException {
		return rispostaUtentePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of risposta utentes.
	 *
	 * @return the number of risposta utentes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getRispostaUtentesCount() throws SystemException {
		return rispostaUtentePersistence.countAll();
	}

	/**
	 * Updates the risposta utente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rispostaUtente the risposta utente
	 * @return the risposta utente that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RispostaUtente updateRispostaUtente(RispostaUtente rispostaUtente)
		throws SystemException {
		return rispostaUtentePersistence.update(rispostaUtente);
	}

	/**
	 * Returns the argomento local service.
	 *
	 * @return the argomento local service
	 */
	public it.quizscuola.portlet.service.ArgomentoLocalService getArgomentoLocalService() {
		return argomentoLocalService;
	}

	/**
	 * Sets the argomento local service.
	 *
	 * @param argomentoLocalService the argomento local service
	 */
	public void setArgomentoLocalService(
		it.quizscuola.portlet.service.ArgomentoLocalService argomentoLocalService) {
		this.argomentoLocalService = argomentoLocalService;
	}

	/**
	 * Returns the argomento remote service.
	 *
	 * @return the argomento remote service
	 */
	public it.quizscuola.portlet.service.ArgomentoService getArgomentoService() {
		return argomentoService;
	}

	/**
	 * Sets the argomento remote service.
	 *
	 * @param argomentoService the argomento remote service
	 */
	public void setArgomentoService(
		it.quizscuola.portlet.service.ArgomentoService argomentoService) {
		this.argomentoService = argomentoService;
	}

	/**
	 * Returns the argomento persistence.
	 *
	 * @return the argomento persistence
	 */
	public ArgomentoPersistence getArgomentoPersistence() {
		return argomentoPersistence;
	}

	/**
	 * Sets the argomento persistence.
	 *
	 * @param argomentoPersistence the argomento persistence
	 */
	public void setArgomentoPersistence(
		ArgomentoPersistence argomentoPersistence) {
		this.argomentoPersistence = argomentoPersistence;
	}

	/**
	 * Returns the classe local service.
	 *
	 * @return the classe local service
	 */
	public it.quizscuola.portlet.service.ClasseLocalService getClasseLocalService() {
		return classeLocalService;
	}

	/**
	 * Sets the classe local service.
	 *
	 * @param classeLocalService the classe local service
	 */
	public void setClasseLocalService(
		it.quizscuola.portlet.service.ClasseLocalService classeLocalService) {
		this.classeLocalService = classeLocalService;
	}

	/**
	 * Returns the classe remote service.
	 *
	 * @return the classe remote service
	 */
	public it.quizscuola.portlet.service.ClasseService getClasseService() {
		return classeService;
	}

	/**
	 * Sets the classe remote service.
	 *
	 * @param classeService the classe remote service
	 */
	public void setClasseService(
		it.quizscuola.portlet.service.ClasseService classeService) {
		this.classeService = classeService;
	}

	/**
	 * Returns the classe persistence.
	 *
	 * @return the classe persistence
	 */
	public ClassePersistence getClassePersistence() {
		return classePersistence;
	}

	/**
	 * Sets the classe persistence.
	 *
	 * @param classePersistence the classe persistence
	 */
	public void setClassePersistence(ClassePersistence classePersistence) {
		this.classePersistence = classePersistence;
	}

	/**
	 * Returns the domanda local service.
	 *
	 * @return the domanda local service
	 */
	public it.quizscuola.portlet.service.DomandaLocalService getDomandaLocalService() {
		return domandaLocalService;
	}

	/**
	 * Sets the domanda local service.
	 *
	 * @param domandaLocalService the domanda local service
	 */
	public void setDomandaLocalService(
		it.quizscuola.portlet.service.DomandaLocalService domandaLocalService) {
		this.domandaLocalService = domandaLocalService;
	}

	/**
	 * Returns the domanda remote service.
	 *
	 * @return the domanda remote service
	 */
	public it.quizscuola.portlet.service.DomandaService getDomandaService() {
		return domandaService;
	}

	/**
	 * Sets the domanda remote service.
	 *
	 * @param domandaService the domanda remote service
	 */
	public void setDomandaService(
		it.quizscuola.portlet.service.DomandaService domandaService) {
		this.domandaService = domandaService;
	}

	/**
	 * Returns the domanda persistence.
	 *
	 * @return the domanda persistence
	 */
	public DomandaPersistence getDomandaPersistence() {
		return domandaPersistence;
	}

	/**
	 * Sets the domanda persistence.
	 *
	 * @param domandaPersistence the domanda persistence
	 */
	public void setDomandaPersistence(DomandaPersistence domandaPersistence) {
		this.domandaPersistence = domandaPersistence;
	}

	/**
	 * Returns the materia local service.
	 *
	 * @return the materia local service
	 */
	public it.quizscuola.portlet.service.MateriaLocalService getMateriaLocalService() {
		return materiaLocalService;
	}

	/**
	 * Sets the materia local service.
	 *
	 * @param materiaLocalService the materia local service
	 */
	public void setMateriaLocalService(
		it.quizscuola.portlet.service.MateriaLocalService materiaLocalService) {
		this.materiaLocalService = materiaLocalService;
	}

	/**
	 * Returns the materia remote service.
	 *
	 * @return the materia remote service
	 */
	public it.quizscuola.portlet.service.MateriaService getMateriaService() {
		return materiaService;
	}

	/**
	 * Sets the materia remote service.
	 *
	 * @param materiaService the materia remote service
	 */
	public void setMateriaService(
		it.quizscuola.portlet.service.MateriaService materiaService) {
		this.materiaService = materiaService;
	}

	/**
	 * Returns the materia persistence.
	 *
	 * @return the materia persistence
	 */
	public MateriaPersistence getMateriaPersistence() {
		return materiaPersistence;
	}

	/**
	 * Sets the materia persistence.
	 *
	 * @param materiaPersistence the materia persistence
	 */
	public void setMateriaPersistence(MateriaPersistence materiaPersistence) {
		this.materiaPersistence = materiaPersistence;
	}

	/**
	 * Returns the risposta local service.
	 *
	 * @return the risposta local service
	 */
	public it.quizscuola.portlet.service.RispostaLocalService getRispostaLocalService() {
		return rispostaLocalService;
	}

	/**
	 * Sets the risposta local service.
	 *
	 * @param rispostaLocalService the risposta local service
	 */
	public void setRispostaLocalService(
		it.quizscuola.portlet.service.RispostaLocalService rispostaLocalService) {
		this.rispostaLocalService = rispostaLocalService;
	}

	/**
	 * Returns the risposta remote service.
	 *
	 * @return the risposta remote service
	 */
	public it.quizscuola.portlet.service.RispostaService getRispostaService() {
		return rispostaService;
	}

	/**
	 * Sets the risposta remote service.
	 *
	 * @param rispostaService the risposta remote service
	 */
	public void setRispostaService(
		it.quizscuola.portlet.service.RispostaService rispostaService) {
		this.rispostaService = rispostaService;
	}

	/**
	 * Returns the risposta persistence.
	 *
	 * @return the risposta persistence
	 */
	public RispostaPersistence getRispostaPersistence() {
		return rispostaPersistence;
	}

	/**
	 * Sets the risposta persistence.
	 *
	 * @param rispostaPersistence the risposta persistence
	 */
	public void setRispostaPersistence(RispostaPersistence rispostaPersistence) {
		this.rispostaPersistence = rispostaPersistence;
	}

	/**
	 * Returns the risposta utente local service.
	 *
	 * @return the risposta utente local service
	 */
	public it.quizscuola.portlet.service.RispostaUtenteLocalService getRispostaUtenteLocalService() {
		return rispostaUtenteLocalService;
	}

	/**
	 * Sets the risposta utente local service.
	 *
	 * @param rispostaUtenteLocalService the risposta utente local service
	 */
	public void setRispostaUtenteLocalService(
		it.quizscuola.portlet.service.RispostaUtenteLocalService rispostaUtenteLocalService) {
		this.rispostaUtenteLocalService = rispostaUtenteLocalService;
	}

	/**
	 * Returns the risposta utente remote service.
	 *
	 * @return the risposta utente remote service
	 */
	public it.quizscuola.portlet.service.RispostaUtenteService getRispostaUtenteService() {
		return rispostaUtenteService;
	}

	/**
	 * Sets the risposta utente remote service.
	 *
	 * @param rispostaUtenteService the risposta utente remote service
	 */
	public void setRispostaUtenteService(
		it.quizscuola.portlet.service.RispostaUtenteService rispostaUtenteService) {
		this.rispostaUtenteService = rispostaUtenteService;
	}

	/**
	 * Returns the risposta utente persistence.
	 *
	 * @return the risposta utente persistence
	 */
	public RispostaUtentePersistence getRispostaUtentePersistence() {
		return rispostaUtentePersistence;
	}

	/**
	 * Sets the risposta utente persistence.
	 *
	 * @param rispostaUtentePersistence the risposta utente persistence
	 */
	public void setRispostaUtentePersistence(
		RispostaUtentePersistence rispostaUtentePersistence) {
		this.rispostaUtentePersistence = rispostaUtentePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("it.quizscuola.portlet.model.RispostaUtente",
			rispostaUtenteLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.quizscuola.portlet.model.RispostaUtente");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return RispostaUtente.class;
	}

	protected String getModelClassName() {
		return RispostaUtente.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = rispostaUtentePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.quizscuola.portlet.service.ArgomentoLocalService.class)
	protected it.quizscuola.portlet.service.ArgomentoLocalService argomentoLocalService;
	@BeanReference(type = it.quizscuola.portlet.service.ArgomentoService.class)
	protected it.quizscuola.portlet.service.ArgomentoService argomentoService;
	@BeanReference(type = ArgomentoPersistence.class)
	protected ArgomentoPersistence argomentoPersistence;
	@BeanReference(type = it.quizscuola.portlet.service.ClasseLocalService.class)
	protected it.quizscuola.portlet.service.ClasseLocalService classeLocalService;
	@BeanReference(type = it.quizscuola.portlet.service.ClasseService.class)
	protected it.quizscuola.portlet.service.ClasseService classeService;
	@BeanReference(type = ClassePersistence.class)
	protected ClassePersistence classePersistence;
	@BeanReference(type = it.quizscuola.portlet.service.DomandaLocalService.class)
	protected it.quizscuola.portlet.service.DomandaLocalService domandaLocalService;
	@BeanReference(type = it.quizscuola.portlet.service.DomandaService.class)
	protected it.quizscuola.portlet.service.DomandaService domandaService;
	@BeanReference(type = DomandaPersistence.class)
	protected DomandaPersistence domandaPersistence;
	@BeanReference(type = it.quizscuola.portlet.service.MateriaLocalService.class)
	protected it.quizscuola.portlet.service.MateriaLocalService materiaLocalService;
	@BeanReference(type = it.quizscuola.portlet.service.MateriaService.class)
	protected it.quizscuola.portlet.service.MateriaService materiaService;
	@BeanReference(type = MateriaPersistence.class)
	protected MateriaPersistence materiaPersistence;
	@BeanReference(type = it.quizscuola.portlet.service.RispostaLocalService.class)
	protected it.quizscuola.portlet.service.RispostaLocalService rispostaLocalService;
	@BeanReference(type = it.quizscuola.portlet.service.RispostaService.class)
	protected it.quizscuola.portlet.service.RispostaService rispostaService;
	@BeanReference(type = RispostaPersistence.class)
	protected RispostaPersistence rispostaPersistence;
	@BeanReference(type = it.quizscuola.portlet.service.RispostaUtenteLocalService.class)
	protected it.quizscuola.portlet.service.RispostaUtenteLocalService rispostaUtenteLocalService;
	@BeanReference(type = it.quizscuola.portlet.service.RispostaUtenteService.class)
	protected it.quizscuola.portlet.service.RispostaUtenteService rispostaUtenteService;
	@BeanReference(type = RispostaUtentePersistence.class)
	protected RispostaUtentePersistence rispostaUtentePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private RispostaUtenteLocalServiceClpInvoker _clpInvoker = new RispostaUtenteLocalServiceClpInvoker();
}