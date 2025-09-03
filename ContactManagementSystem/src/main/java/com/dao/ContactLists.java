package com.dao;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.helper.FactoryProvider;
import com.entities.Contact;


public class ContactLists{
	public static List<Contact> getListByUserId(int userId){
		Session session=FactoryProvider.getFactory().openSession();
		Query q=session.createQuery("from Contact where user_id=:id ORDER BY name ASC");
		q.setParameter("id", userId);
		List<Contact> l=q.list();
		session.close();
		return l;
	}
}
