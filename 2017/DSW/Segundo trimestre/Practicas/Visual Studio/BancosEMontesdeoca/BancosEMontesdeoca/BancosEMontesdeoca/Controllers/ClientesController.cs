using BancosEMontesdeoca.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BancosEMontesdeoca.Controllers
{
    [Authorize]
    [ManagerFilter]
    public class ClientesController : Controller
    {
        /// <summary>
        /// Lista de clientes global
        /// </summary>
        List<Clientes> ListaClientes = new List<Clientes>();

        // GET: Clientes
        public ActionResult Index()
        {
            return RedirectToAction("Lista", "Clientes");
        }

        /// <summary>
        /// Retorna una vista con al lista de clientes cargada
        /// </summary>
        /// <returns></returns>
        public ActionResult Lista()
        {
            /// Conexion a base de datos
            using (BancosEntities ctx = new BancosEntities())
            {
                /// Asignar la lista
                ListaClientes = ctx.Clientes.ToList();
            }

            /// Devolver la vista con la lista
            return View(ListaClientes);
        }

        /// <summary>
        /// Retorna la vista de creacion de cliente
        /// </summary>
        /// <returns></returns>
        public ActionResult Create()
        {
            /// Retorna vista
            return View();
        }

        /// <summary>
        /// Metodo que añade un cliente a la base de datos
        /// </summary>
        /// <param name="c">Cliente</param>
        /// <returns></returns>
        [HttpPost]
        public ActionResult Create(Clientes c)
        {
            /// Conexion a la base de dats
            using (BancosEntities ctx = new BancosEntities())
            {
                /// Añade a la lista
                ctx.Clientes.Add(c);

                /// Guarda cambios
                ctx.SaveChanges();
            }

            /// Retorna a la lista
            return RedirectToAction("Lista", "Clientes");
        }

        /// <summary>
        /// Elimina una cuenta
        /// </summary>
        /// <param name="id">Id de la cuenta</param>
        /// <returns></returns>
        public ActionResult Delete(int id)
        {
            /// Conexion a la base de datos
            using (BancosEntities ctx = new BancosEntities())
            {
                /// Busca el cliente que coincida con la Id
                Clientes c = ctx.Clientes.Single(x => x.IdCliente == id);

                /// Elimina ese cliente en la lista
                ctx.Clientes.Remove(c);

                /// Guarda los cambios
                ctx.SaveChanges();
            }

            /// Retorna a la lista
            return RedirectToAction("Lista", "Clientes");
        }

        /// <summary>
        /// Muestra para editar un cliente
        /// </summary>
        /// <param name="id">Id de cliente</param>
        /// <returns></returns>
        public ActionResult Edit(int id)
        {
            /// Cliente a devolver
            Clientes c = new Clientes();

            /// Conexion a la base de datos
            using (BancosEntities ctx = new BancosEntities())
            {
                /// Busqueda de cliente en la base de datos
                Clientes edit = ctx.Clientes.Single(x => x.IdCliente == id);

                /// Reasignacion de valores
                c.IdCliente = edit.IdCliente;
                c.NifNie = edit.NifNie;
                c.Nombre = edit.Nombre;
                c.Operaciones = edit.Operaciones;
                c.Prestamos = edit.Prestamos;
                c.Apellidos = edit.Apellidos;
                c.Cuentas = edit.Cuentas;
            }

            /// Devolver la vista con el cliente
            return View(c);
        }

        /// <summary>
        /// Metodo que edita un cliente
        /// </summary>
        /// <param name="id">Id de cliente</param>
        /// <param name="c">Datos nuevos de cliente</param>
        /// <returns></returns>
        [HttpPost]
        public ActionResult Edit(int id, Clientes c)
        {
            /// Conexion a la base de datos
            using (BancosEntities ctx = new BancosEntities())
            {
                /// Buscar el usuario en la base de datos
                var edit = ctx.Clientes.Single(x => x.IdCliente == id);

                /// Reasignar valores
                edit.NifNie = c.NifNie;
                edit.Nombre = c.Nombre;
                edit.Apellidos = c.Apellidos;
                edit.Operaciones = c.Operaciones;
                edit.Cuentas = c.Cuentas;
                edit.Prestamos = c.Prestamos;

                /// Guardar cambios
                ctx.SaveChanges();
            }

            /// Retornar a la lista
            return RedirectToAction("Lista", "Clientes");
        }

        /// <summary>
        /// Vista que muestra los detalles del cliente
        /// </summary>
        /// <param name="id">Id del cliente</param>
        /// <returns></returns>
        public ActionResult Details(int id)
        {
            /// Cliente a mostrar
            Clientes c = new Clientes();

            /// Conexion a la base de datos
            using (BancosEntities ctx = new BancosEntities())
            {
                /// Buscar el cliente a mostrar
                Clientes edit = ctx.Clientes.Single(x => x.IdCliente == id);

                /// Reasignar valores
                c.IdCliente = edit.IdCliente;
                c.NifNie = edit.NifNie;
                c.Nombre = edit.Nombre;
                c.Operaciones = edit.Operaciones;
                c.Prestamos = edit.Prestamos;
                c.Apellidos = edit.Apellidos;
                c.Cuentas = edit.Cuentas;
            }

            /// Retornar vista con el cliente
            return View(c);
        }
    }
}