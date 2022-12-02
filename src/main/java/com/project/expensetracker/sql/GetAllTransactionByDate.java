package com.project.expensetracker.sql;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;

public class GetAllTransactionByDate {

    public static Query createQuery(EntityManager entityManager, Date date) {
        Query query = entityManager.createNativeQuery(getQueryString());
        query.setParameter("date", date);
        return query;
    }

    private static String getQueryString() {
        return "SELECT * FROM Transaction_Details WHERE DATE >= (:date)";
    }

}
