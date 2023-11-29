package principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import dao.ConfigHibernate;
import dao.DaoTecnico;
import entidades.Cliente;
import entidades.Especialidad;
import entidades.Incidente;
import entidades.Operador;
import entidades.Tecnico;

public class Main {

	public static void main(String[] args) {
		
		Main.cargarDatos();

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		
		//3.b
		String especialidadElegida = "Especialidad2";
		Long cantidadDeTecnicosQueCorrespondenAXEspecialidad= (Long) session.createQuery("SELECT count(*) FROM Tecnico t inner join t.especialidad e where e.nombre = :especialidad").setParameter("especialidad", especialidadElegida).uniqueResult();
		
		//3.c
		Long cantidadDeClientes= (Long) session.createQuery("SELECT count(*) FROM Cliente").uniqueResult();
		
		session.getTransaction().commit();

		System.out.println("La cantidad de tecnicos que corresponden a la especialidad "+ especialidadElegida +" es: "+ cantidadDeTecnicosQueCorrespondenAXEspecialidad);
		System.out.println("La cantidad de clientes que forman parte del sistema son: "+ cantidadDeClientes);
		
		ch.cerrarSession();
	}


	public static void cargarDatos() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		
		Operador operador1 = new Operador("juan", "lopez", "1111111","juan@mail.com", 11111);
		Operador operador2 = new Operador("jose", "lopez", "2222222","jose@mail.com", 22222);
		Operador operador3 = new Operador("julio", "lopez", "3333333","julio@mail.com", 33333);
		Operador operador4 = new Operador("pepe", "lopez", "4444444","pepe@mail.com", 44444);
		Operador operador5 = new Operador("fede", "lopez", "5555555","fede@mail.com", 55555);
		
		Especialidad especialidad1 = new Especialidad("Especialidad1");
		Especialidad especialidad2 = new Especialidad("Especialidad2");
		Especialidad especialidad3 = new Especialidad("Especialidad3");
		Especialidad especialidad4 = new Especialidad("Especialidad4");
		Especialidad especialidad5 = new Especialidad("Especialidad5");		
		
		Cliente cliente1 = new Cliente("Razon social 1", "10101010101", "1111111", "email-1@example.com", "24765918", "Calle 111, Ciudad 1, Provincia 1");
		Cliente cliente2 = new Cliente("Razon social 2", "20202020202", "2222222", "email-2@example.com", "31876091", "Calle 222, Ciudad 2, Provincia 2");
		Cliente cliente3 = new Cliente("Razon social 3", "30303030303", "3333333", "email-3@example.com", "11837197", "Calle 333, Ciudad 3, Provincia 3");
		Cliente cliente4 = new Cliente("Razon social 4", "40404040404", "4444444", "email-4@example.com", "39171631", "Calle 444, Ciudad 4, Provincia 4");
		Cliente cliente5 = new Cliente("Razon social 5", "50505050505", "5555555", "email-5@example.com", "27176625", "Calle 555, Ciudad 5, Provincia 5");

		Incidente incidente1 = new Incidente (operador1, cliente1, especialidad1, "Descripcion1", Date.from(LocalDate.of(2023, 1, 1).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2023, 11, 25).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()));
		Incidente incidente2 = new Incidente(operador2, cliente2, especialidad2, "Descripcion2", Date.from(LocalDate.of(2023, 2, 2).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()),Date.from(LocalDate.of(2023, 11, 26).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()));
		Incidente incidente3 = new Incidente(operador3, cliente3, especialidad3, "Descripcion3", Date.from(LocalDate.of(2023, 3, 3).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2023, 11, 24).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()));
		Incidente incidente4 = new Incidente(operador4, cliente4, especialidad4, "Descripcion4", Date.from(LocalDate.of(2023, 4, 4).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2023, 11, 21).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()));
		Incidente incidente5 = new Incidente(operador5, cliente5, especialidad5, "Descripcion5", Date.from(LocalDate.of(2023, 5, 5).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()), Date.from(LocalDate.of(2023, 11, 22).atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires")).toInstant()));
		
		Set<Incidente> listaIncidentes1 = new HashSet<>();
		Set<Incidente> listaIncidentes2 = new HashSet<>();
		Set<Incidente> listaIncidentes3 = new HashSet<>();
		Set<Incidente> listaIncidentes4 = new HashSet<>();
		Set<Incidente> listaIncidentes5 = new HashSet<>();
		listaIncidentes1.add(incidente1);
		listaIncidentes2.add(incidente2);
		listaIncidentes3.add(incidente3);
		listaIncidentes4.add(incidente4);
		listaIncidentes5.add(incidente5);
		
		Tecnico tecnico1 = new Tecnico ("leo", "flores", "1111111","leo@mail.com", 11111, especialidad1, listaIncidentes1);
		Tecnico tecnico2 = new Tecnico ("lionel", "flores", "2222222","lionel@mail.com", 22222, especialidad2, listaIncidentes2);
		Tecnico tecnico3 = new Tecnico ("jose", "flores", "3333333","jose@mail.com", 33333, especialidad3, listaIncidentes3);
		Tecnico tecnico4 = new Tecnico ("maria", "flores", "4444444","maria@mail.com", 44444, especialidad4, listaIncidentes4);
		Tecnico tecnico5 = new Tecnico ("sofia", "flores", "5555555","sofia@mail.com", 55555, especialidad5, listaIncidentes5);
	
		DaoTecnico daoTecnico = new DaoTecnico();
		
		daoTecnico.Add(tecnico1);
		daoTecnico.Add(tecnico2);
		daoTecnico.Add(tecnico3);
		daoTecnico.Add(tecnico4);
		daoTecnico.Add(tecnico5);
		
		session.getTransaction().commit();
		ch.cerrarSession();
		
	}

}