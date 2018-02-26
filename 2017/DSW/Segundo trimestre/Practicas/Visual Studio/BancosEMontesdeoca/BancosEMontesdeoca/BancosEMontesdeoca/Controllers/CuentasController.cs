using BancosEMontesdeoca.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BancosEMontesdeoca.Controllers
{
    [Authorize]
    [AdminFilter]
    public class CuentasController : Controller
    {
        public static List<Cuentas> Lista = new List<Cuentas>();
        // GET: Cuentas

        public ActionResult Index()
        {
            return RedirectToAction("Get", "Cuentas");
        }

        public ActionResult Get()
        {
            BancosEntities ctx = new BancosEntities();
            Lista = ctx.Cuentas.ToList();
            return View(Lista);
        }

        public ActionResult Create()
        {
            BancosEntities ctx = new BancosEntities();

            ViewBag.IdCliente = new SelectList(ctx.Clientes.OrderBy(x => x.NifNie), "idCliente", "NifNie");
            ViewBag.idEntidad = new SelectList(ctx.Entidades.OrderBy(x => x.Nombre), "idEntidad", "Nombre");
            ViewBag.idTipoCuenta = new SelectList(ctx.TiposCuenta.OrderBy(x => x.Denominacion), "idTipoCuenta", "Denominacion");

            return View();
        }
        [HttpPost]
        public ActionResult Create(Cuentas c)
        {
            if (ModelState.IsValid)
            {
                BancosEntities ctx = new BancosEntities();
                ctx.Cuentas.Add(c);
                ctx.SaveChanges();
                return RedirectToAction("Get", "Cuentas");
            }
            else
            {
                return RedirectToAction("Get", "Cuentas");
            }

        }

        public ActionResult Edit(int id)
        {
            BancosEntities ctx = new BancosEntities();

            Cuentas c = ctx.Cuentas.Single(x => x.IdCuenta == id);

            ViewBag.IdCliente = new SelectList(ctx.Clientes.OrderBy(x => x.NifNie), "idCliente", "NifNie", c.IdCliente);
            ViewBag.idEntidad = new SelectList(ctx.Entidades.OrderBy(x => x.Nombre), "idEntidad", "Nombre", c.IdEntidad);
            ViewBag.idTipoCuenta = new SelectList(ctx.TiposCuenta.OrderBy(x => x.Denominacion), "idTipoCuenta", "Denominacion", c.IdTipoCuenta);

            return View(c);
        }
        [HttpPost]
        public ActionResult Edit(int id, Cuentas c)
        {
            if (ModelState.IsValid)
            {
                BancosEntities ctx = new BancosEntities();

                Cuentas edit = ctx.Cuentas.Single(x => x.IdCuenta == id);

                edit.IdCliente = c.IdCliente;
                edit.IdEntidad = c.IdEntidad;
                edit.IdTipoCuenta = c.IdTipoCuenta;
                edit.NumCuenta = c.NumCuenta;
                edit.Saldo = c.Saldo;
                edit.TiposCuenta = c.TiposCuenta;

                ctx.SaveChanges();

                return RedirectToAction("Get", "Cuentas");
            }
            else
            {
                return RedirectToAction("Get", "Cuentas");
            }


        }

        public ActionResult Details(int id)
        {
            BancosEntities ctx = new BancosEntities();

            Cuentas c = ctx.Cuentas.Single(x => x.IdCuenta == id);

            return View(c);
        }

        public ActionResult Delete(int id)
        {
            BancosEntities ctx = new BancosEntities();

            ctx.Cuentas.Remove(ctx.Cuentas.Single(x => x.IdCuenta == id));
            ctx.SaveChanges();

            return RedirectToAction("Get", "Cuentas");
        }
    }
}