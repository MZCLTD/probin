package com.mz.probin.dao;

import java.util.List;


public interface GenericDao {

    /**
     * Get an entity by it's id.
     *
     * @param clazz the {@link java.lang.Class} of the entity.
     * @param id the id of the entity to get.
     * @return the entity if found or {@code null}.
     */
    <T> T getEntityById(Class<T> clazz, Object id);

    /**
     * Persist an entity.
     *
     * <p>Implementers should make sure that both save and update
     * operations are handled by a call to this method.
     *
     * @param entity the entity to persist.
     * @return The persisted entity after the persistence op has been effected.
     */
    <T> T persist(T entity);

    /**
     * Get all entities of a particular type.
     *
     * @param entityClass the entity type
     * @return a list of all entities of the type.
     */
    <T> List<T> getAll(Class<T> entityClass);

	<T> T getEntityByStringValue(String field, String fieldValue, Class<T> clazz);

	<T> List<T> getEntityListByStringValue(String field, String fieldValue,
			Class<T> clazz);

}
