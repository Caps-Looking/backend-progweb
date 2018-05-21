package edu.unievangelica.programacaoweb.ecommerce.service;

import edu.unievangelica.programacaoweb.ecommerce.model.dto.BaseResponse;
import edu.unievangelica.programacaoweb.ecommerce.model.entity.IEntity;
import edu.unievangelica.programacaoweb.ecommerce.model.exception.BaseException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import java.util.List;

public abstract class AbstractService<T extends IEntity> {

    public abstract JpaRepository<T, Long> getRepository();

    /**
     * Save the entity
     *
     * @param entity that is going to be saved
     * @return the saved entity
     */
    public T save(T entity) {
        try {
            return getRepository().save(entity);
        } catch (Exception e) {
            throw new BaseException("Problem on save", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update the entity
     *
     * @param entity that is going to be updated
     * @return the updated entity
     */
    public T update(T entity) {
        T dbEntity = findById(entity.getId());
        entity.setId(dbEntity.getId());
        return save(entity);
    }

    /**
     * Delete the entity
     *
     * @param id of the entity that is going to be deleted
     */
    public BaseResponse delete(Long id) {
        getRepository().deleteById(findById(id).getId());
        return new BaseResponse("Successfully deleted", null, HttpStatus.OK);
    }

    /**
     * List all the entities of DB
     *
     * @return all the entities
     */
    public List<T> findAll() {
        return getRepository().findAll();
    }

    /**
     * Find an entity by the id
     *
     * @param id that is going to be searched
     * @return the searched entity
     */
    public T findById(Long id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new BaseException("Object not found", null, HttpStatus.NOT_FOUND));
    }

}
