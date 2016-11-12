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

package it.quizscuola.portlet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Argomento. This utility wraps
 * {@link it.quizscuola.portlet.service.impl.ArgomentoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Salvatore
 * @see ArgomentoLocalService
 * @see it.quizscuola.portlet.service.base.ArgomentoLocalServiceBaseImpl
 * @see it.quizscuola.portlet.service.impl.ArgomentoLocalServiceImpl
 * @generated
 */
public class ArgomentoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.quizscuola.portlet.service.impl.ArgomentoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the argomento to the database. Also notifies the appropriate model listeners.
	*
	* @param argomento the argomento
	* @return the argomento that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento addArgomento(
		it.quizscuola.portlet.model.Argomento argomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addArgomento(argomento);
	}

	/**
	* Creates a new argomento with the primary key. Does not add the argomento to the database.
	*
	* @param idArgomento the primary key for the new argomento
	* @return the new argomento
	*/
	public static it.quizscuola.portlet.model.Argomento createArgomento(
		long idArgomento) {
		return getService().createArgomento(idArgomento);
	}

	/**
	* Deletes the argomento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento that was removed
	* @throws PortalException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento deleteArgomento(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteArgomento(idArgomento);
	}

	/**
	* Deletes the argomento from the database. Also notifies the appropriate model listeners.
	*
	* @param argomento the argomento
	* @return the argomento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento deleteArgomento(
		it.quizscuola.portlet.model.Argomento argomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteArgomento(argomento);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.quizscuola.portlet.model.Argomento fetchArgomento(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchArgomento(idArgomento);
	}

	/**
	* Returns the argomento with the matching UUID and company.
	*
	* @param uuid the argomento's UUID
	* @param companyId the primary key of the company
	* @return the matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchArgomentoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchArgomentoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the argomento matching the UUID and group.
	*
	* @param uuid the argomento's UUID
	* @param groupId the primary key of the group
	* @return the matching argomento, or <code>null</code> if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento fetchArgomentoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchArgomentoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the argomento with the primary key.
	*
	* @param idArgomento the primary key of the argomento
	* @return the argomento
	* @throws PortalException if a argomento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento getArgomento(
		long idArgomento)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomento(idArgomento);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the argomento with the matching UUID and company.
	*
	* @param uuid the argomento's UUID
	* @param companyId the primary key of the company
	* @return the matching argomento
	* @throws PortalException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento getArgomentoByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentoByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the argomento matching the UUID and group.
	*
	* @param uuid the argomento's UUID
	* @param groupId the primary key of the group
	* @return the matching argomento
	* @throws PortalException if a matching argomento could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento getArgomentoByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentoByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the argomentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.quizscuola.portlet.model.impl.ArgomentoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of argomentos
	* @param end the upper bound of the range of argomentos (not inclusive)
	* @return the range of argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.quizscuola.portlet.model.Argomento> getArgomentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentos(start, end);
	}

	/**
	* Returns the number of argomentos.
	*
	* @return the number of argomentos
	* @throws SystemException if a system exception occurred
	*/
	public static int getArgomentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentosCount();
	}

	/**
	* Updates the argomento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param argomento the argomento
	* @return the argomento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.quizscuola.portlet.model.Argomento updateArgomento(
		it.quizscuola.portlet.model.Argomento argomento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateArgomento(argomento);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static it.quizscuola.portlet.model.Argomento addArgomento(
		com.liferay.portal.service.ServiceContext ctx,
		java.lang.String descArgomento, long idMateria) {
		return getService().addArgomento(ctx, descArgomento, idMateria);
	}

	public static it.quizscuola.portlet.model.Argomento updateArgomento(
		long idArgomento, java.lang.String descArgomento)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.quizscuola.portlet.NoSuchArgomentoException {
		return getService().updateArgomento(idArgomento, descArgomento);
	}

	public static java.util.List<it.quizscuola.portlet.model.Argomento> getArgomentos(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentos(start, end, orderByComparator);
	}

	public static java.util.List<it.quizscuola.portlet.model.Argomento> getArgomentiByMateria(
		long idMateria, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getArgomentiByMateria(idMateria, start, end,
			orderByComparator);
	}

	public static int getArgomentiByMateriaCount(long idMateria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getArgomentiByMateriaCount(idMateria);
	}

	public static void deleteDomandasByArgomento(long idUtente, long idArgomento) {
		getService().deleteDomandasByArgomento(idUtente, idArgomento);
	}

	public static void deleteDomandasERisposteByArgomento(long idArgomento) {
		getService().deleteDomandasERisposteByArgomento(idArgomento);
	}

	public static void clearService() {
		_service = null;
	}

	public static ArgomentoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ArgomentoLocalService.class.getName());

			if (invokableLocalService instanceof ArgomentoLocalService) {
				_service = (ArgomentoLocalService)invokableLocalService;
			}
			else {
				_service = new ArgomentoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ArgomentoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ArgomentoLocalService service) {
	}

	private static ArgomentoLocalService _service;
}