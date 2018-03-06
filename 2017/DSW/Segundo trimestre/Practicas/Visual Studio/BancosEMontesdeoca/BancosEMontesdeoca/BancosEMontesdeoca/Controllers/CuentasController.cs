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
    public class CuentasController : Controller
    {
        /// <summary>
        /// Lista de cuentas
        /// </summary>
        public static List<Cuentas> ListaCuentas = new List<Cuentas>();
        // GET: Cuentas

        /// <summary>
        /// Metodo que devuelve el index
        /// </summary>
        /// <returns></returns>
        public ActionResult Index()
        {
            /// Al acceder a index, dirige a Lista directamente
            return RedirectToAction("Lista", "Cuentas");
        }

        /// <summary>
        /// Metodo que muestra la lista de cuentas
        /// </summary>
        /// <returns></returns>
        public ActionResult Lista()
        {
            /// Contexto para la conexion en el entity framework
            BancosEntities ctx = new BancosEntities();

            /// Pedir las listas
            ListaCuentas = ctx.Cuentas.ToList();

            /// Devolver en el modelo
            return View(ListaCuentas);
        }

        /// <summary>
        /// Metodo que muestra la vista de cracion de cuenta
        /// </summary>
        /// <returns>Lista de cuentas</returns>
        public ActionResult CreateModel()
        {
            /// Contexto para la conexion en el entity framework
            BancosEntities ctx = new BancosEntities();

            /// Guardar en el viewbag un selectlist cargado con los valores y ordenados
            ViewBag.IdCliente = new SelectList(ctx.Clientes.OrderBy(x => x.NifNie), "idCliente", "NifNie");
            ViewBag.idEntidad = new SelectList(ctx.Entidades.OrderBy(x => x.Nombre), "idEntidad", "Nombre");
            ViewBag.idTipoCuenta = new SelectList(ctx.TiposCuenta.OrderBy(x => x.Denominacion), "idTipoCuenta", "Denominacion");

            /// Retornar vista
            return View();
        }
        /// <summary>
        /// Funcion que añade una cuenta a la base de datos
        /// </summary>
        /// <param name="c">Cuenta</param>
        /// <returns>Lista de cuentas</returns>
        [HttpPost]
        public ActionResult CreateModel(Cuentas c)
        {
            /// Si valida
            if (ModelState.IsValid)
            {
                /// Contexto para la conexion en el entity framework
                BancosEntities ctx = new BancosEntities();

                /// Añadir a la lista el objeto
                ctx.Cuentas.Add(c);

                /// Guardar cambios
                ctx.SaveChanges();

                /// Retornar a la lista
                return RedirectToAction("Lista", "Cuentas");
            }
            else
            {
                /// No deberia de entrar por aqui, porque no valida, pero en todo caso devolver a la Lista
                return RedirectToAction("Lista", "Cuentas");
            }
        }

        /// <summary>
        /// Metodo que muestra una cuenta para editar
        /// </summary>
        /// <param name="id">Id de la cuenta</param>
        /// <returns>Vista de edit cargada</returns>
        public ActionResult Edit(int id)
        {
            /// Contexto para la conexion en el entity framework
            BancosEntities ctx = new BancosEntities();

            /// Busca la cuenta que coincida con ese ID
            Cuentas c = ctx.Cuentas.Single(x => x.IdCuenta == id);

            /// Guardar en el viewbag un selectlist cargado con los valores y ordenados, con el valor seleccionado
            ViewBag.IdCliente = new SelectList(ctx.Clientes.OrderBy(x => x.NifNie), "idCliente", "NifNie", c.IdCliente);
            ViewBag.idEntidad = new SelectList(ctx.Entidades.OrderBy(x => x.Nombre), "idEntidad", "Nombre", c.IdEntidad);
            ViewBag.idTipoCuenta = new SelectList(ctx.TiposCuenta.OrderBy(x => x.Denominacion), "idTipoCuenta", "Denominacion", c.IdTipoCuenta);

            /// Retorna la vista
            return View(c);
        }
        /// <summary>
        /// Metodo que actualiza una cuenta en la base de datos
        /// </summary>
        /// <param name="id">ID de la cuenta</param>
        /// <param name="c">Cuenta nueva</param>
        /// <returns>Lista de cuentas</returns>
        [HttpPost]
        public ActionResult Edit(int id, Cuentas c)
        {
            /// Si valida
            if (ModelState.IsValid)
            {
                /// Contexto para la conexion en el entity framework
                BancosEntities ctx = new BancosEntities();

                /// Buscar la cuenta que coincida con la Id
                Cuentas edit = ctx.Cuentas.Single(x => x.IdCuenta == id);

                /// Reasignar valores
                edit.IdCliente = c.IdCliente;
                edit.IdEntidad = c.IdEntidad;
                edit.IdTipoCuenta = c.IdTipoCuenta;
                edit.NumCuenta = c.NumCuenta;
                edit.Saldo = c.Saldo;
                edit.TiposCuenta = c.TiposCuenta;

                /// Guardar cambios en la base de datos
                ctx.SaveChanges();

                /// Redireccionar a la lista
                return RedirectToAction("Lista", "Cuentas");
            }
            else
            {
                /// No deberia de entrar por aqui, porque no valida, pero en todo caso devolver a la Lista
                return RedirectToAction("Lista", "Cuentas");
            }
        }

        /// <summary>
        /// Metodo que muestra los detalles de una cuenta
        /// </summary>
        /// <param name="id">Id de la cuenta</param>
        /// <returns>Vista cargada</returns>
        public ActionResult Details(int id)
        {
            /// Contexto para la conexion en el entity framework
            BancosEntities ctx = new BancosEntities();

            /// Buscar la cuenta que coincida con la Id
            Cuentas c = ctx.Cuentas.Single(x => x.IdCuenta == id);

            /// Retornar la vista con la cuenta cargada
            return View(c);
        }

        /// <summary>
        /// Metodo que borra una cuenta de la base de datos
        /// </summary>
        /// <param name="id">Id de la cuenta</param>
        /// <returns>Lista de cuentas</returns>
        public ActionResult Delete(int id)
        {
            /// Contexto para la conexion en el entity framework
            BancosEntities ctx = new BancosEntities();

            /// Elimina la cuenta de la lista que coincida con la Id
            ctx.Cuentas.Remove(ctx.Cuentas.Single(x => x.IdCuenta == id));

            /// Guarda los cambios en la base de datos
            ctx.SaveChanges();

            /// Retorna a la lista
            return RedirectToAction("Lista", "Cuentas");
        }

        /// <summary>
        /// Metodod que muestra las cuentas de un cliente
        /// </summary>
        /// <param name="id">Id de cliente</param>
        /// <returns></returns>
        public ActionResult VerCuentas(int id)
        {
            /// Lista a devolver
            List<Cuentas> list = new List<Cuentas>();

            /// Conexion a base de datos
            BancosEntities ctx = new BancosEntities();

            /// Cuentas que coincidan el Id de cliente con mi id 
            list = ctx.Cuentas.Where(p => p.IdCliente == id).ToList();

            /// Retonar vista con la lista
            return View(list);
        }
    }
}