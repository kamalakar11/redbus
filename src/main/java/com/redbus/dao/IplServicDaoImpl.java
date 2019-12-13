package com.redbus.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.redbus.pojo.Team;

public class IplServicDaoImpl {

	public void registerForIpl(Team team) {
		System.out.println("IplServiceDaoImpl::registerForIpl");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction beginTransaction = session.beginTransaction();
		session.save(team);
		beginTransaction.commit();
		session.close();
		System.out.println("IplServiceDaoImpl::registerForIpl");
	}
	
	public Team getTeam(String teamName) {
		System.out.println("IplServiceDaoImpl::getTeam");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Team team = (Team)session.get(Team.class, teamName);
		System.out.println("IplServiceDaoImpl::getTeam");
		return team;
	}

	public int deleteTeam(String teamName) {
		System.out.println("IplServiceDaoImpl::deleteTeam");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Query deleteQuery = session.createQuery("delete from Team where teamName=?");
		deleteQuery.setParameter(0, teamName);
		int count = deleteQuery.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		System.out.println("IplServiceDaoImpl::deleteTeam");
		return count;
	}
}
