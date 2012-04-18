package com.floreantpos.model.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
/**
 *
 * @author Andres de los Reyes
 */
public abstract class BaseScipioInfoDAO extends com.floreantpos.model.dao._RootDAO{
    
    public static ScipioInfoDAO instance;
    
	/**
	 * Return a singleton of the DAO
	 */
	public static ScipioInfoDAO getInstance () {
		if (null == instance) instance = new ScipioInfoDAO();
		return instance;
	}    
        
	public Class getReferenceClass () {
		return com.floreantpos.model.ScipioInfo.class;
	}
        
	public com.floreantpos.model.ScipioInfo cast (Object object) {
		return (com.floreantpos.model.ScipioInfo) object;
	}        
        
	public com.floreantpos.model.ScipioInfo get(java.lang.Integer key)
	{
		return (com.floreantpos.model.ScipioInfo) get(getReferenceClass(), key);
	}        
        
	public com.floreantpos.model.ScipioInfo get(java.lang.Integer key, Session s)
	{
		return (com.floreantpos.model.ScipioInfo) get(getReferenceClass(), key, s);
	}        

	public com.floreantpos.model.ScipioInfo load(java.lang.Integer key)
	{
		return (com.floreantpos.model.ScipioInfo) load(getReferenceClass(), key);
	}        

	public com.floreantpos.model.ScipioInfo load(java.lang.Integer key, Session s)
	{
		return (com.floreantpos.model.ScipioInfo) load(getReferenceClass(), key, s);
	}        
        
	public com.floreantpos.model.ScipioInfo loadInitialize(java.lang.Integer key, Session s) 
	{ 
		com.floreantpos.model.ScipioInfo obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}       
        
        
        
        
/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.floreantpos.model.ScipioInfo> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<com.floreantpos.model.ScipioInfo> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<com.floreantpos.model.ScipioInfo> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}                
        

        
	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param ScipioInfo a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.floreantpos.model.ScipioInfo ScipioInfo)
	{
		return (java.lang.Integer) super.save(ScipioInfo);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param ScipioInfo a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(com.floreantpos.model.ScipioInfo ScipioInfo, Session s)
	{
		return (java.lang.Integer) save((Object) ScipioInfo, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param ScipioInfo a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.floreantpos.model.ScipioInfo ScipioInfo)
	{
		saveOrUpdate((Object) ScipioInfo);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param ScipioInfo a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.floreantpos.model.ScipioInfo ScipioInfo, Session s)
	{
		saveOrUpdate((Object) ScipioInfo, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param ScipioInfo a transient instance containing updated state
	 */
	public void update(com.floreantpos.model.ScipioInfo ScipioInfo) 
	{
		update((Object) ScipioInfo);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param ScipioInfo a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.floreantpos.model.ScipioInfo ScipioInfo, Session s)
	{
		update((Object) ScipioInfo, s);
	}        

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param ScipioInfo the instance to be removed
	 */
	public void delete(com.floreantpos.model.ScipioInfo ScipioInfo)
	{
		delete((Object) ScipioInfo);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param ScipioInfo the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.floreantpos.model.ScipioInfo ScipioInfo, Session s)
	{
		delete((Object) ScipioInfo, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (com.floreantpos.model.ScipioInfo ScipioInfo, Session s)
	{
		refresh((Object) ScipioInfo, s);
	}

        
        
}