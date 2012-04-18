package com.floreantpos.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.floreantpos.model.ScipioInfo;
/**
 *
 * @author Andres de los Reyes
 */
public class ScipioInfoDAO extends BaseScipioInfoDAO {
    private final static ScipioInfoDAO instance = new ScipioInfoDAO();    
    public ScipioInfoDAO () {}
    
        
	public ScipioInfo initialize(ScipioInfo Scipioinfo) {		
		Session session = createNewSession();
                ScipioInfo newScipioInfo = (ScipioInfo) session.merge(Scipioinfo);
                Hibernate.initialize(newScipioInfo.getPei());
                Hibernate.initialize(newScipioInfo.getPin());
                Hibernate.initialize(newScipioInfo.getTei());
		session.close();
		return newScipioInfo;                
        }
        
/*		
		try {
			session = createNewSession();
			//session.refresh(ScipioInfo);
			ScipioInfo = (ScipioInfo) session.merge(ScipioInfo);
			Hibernate.initialize(ScipioInfo.getScipioInfoModiferGroups());
			List<ScipioInfoModifierGroup> ScipioInfoModiferGroups = ScipioInfo.getScipioInfoModiferGroups();
			if (ScipioInfoModiferGroups != null) {
				for (ScipioInfoModifierGroup ScipioInfoModifierGroup : ScipioInfoModiferGroups) {
					Hibernate.initialize(ScipioInfoModifierGroup.getModifierGroup().getModifiers());
				}
			}
			Hibernate.initialize(ScipioInfo.getShifts());
			return ScipioInfo;
		} finally {
			closeSession(session);
		}
	}    
        * 
        */
}
