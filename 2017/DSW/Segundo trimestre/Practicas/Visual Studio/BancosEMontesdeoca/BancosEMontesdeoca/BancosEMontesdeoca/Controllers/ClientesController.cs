﻿using BancosEMontesdeoca.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BancosEMontesdeoca.Controllers
{
    [Authorize]
    [AdminFilter]
    public class ClientesController : Controller
    {
        List<Clientes> Lista = new List<Clientes>();

        // GET: Clientes
        public ActionResult Index()
        {
            return RedirectToAction("Get", "Clientes");
        }

        public ActionResult Get()
        {

            using (BancosEntities ctx = new BancosEntities())
            {
                Lista = ctx.Clientes.ToList();
            }

            return View(Lista);
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(Clientes c)
        {
            using (BancosEntities ctx = new BancosEntities())
            {
                ctx.Clientes.Add(c);
                ctx.SaveChanges();
            }

            return RedirectToAction("Get", "Clientes");
        }

        public ActionResult Delete(int id)
        {
            using (BancosEntities ctx = new BancosEntities())
            {
                Clientes c = ctx.Clientes.Single(x => x.IdCliente == id);
                ctx.Clientes.Remove(c);
                ctx.SaveChanges();
            }

            return RedirectToAction("Get", "Clientes");
        }

        public ActionResult Edit(int id)
        {

            Clientes c = new Clientes();

            using (BancosEntities ctx = new BancosEntities())
            {
                Clientes edit = ctx.Clientes.Single(x => x.IdCliente == id);
                c.IdCliente = edit.IdCliente;
                c.NifNie = edit.NifNie;
                c.Nombre = edit.Nombre;
                c.Operaciones = edit.Operaciones;
                c.Prestamos = edit.Prestamos;
                c.Apellidos = edit.Apellidos;
                c.Cuentas = edit.Cuentas;
            }

            return View(c);
        }
        [HttpPost]
        public ActionResult Edit(int id, Clientes c)
        {

            using (BancosEntities ctx = new BancosEntities())
            {
                var edit = ctx.Clientes.Single(x => x.IdCliente == id);

                edit.NifNie = c.NifNie;
                edit.Nombre = c.Nombre;
                edit.Apellidos = c.Apellidos;
                edit.Operaciones = c.Operaciones;
                edit.Cuentas = c.Cuentas;
                edit.Prestamos = c.Prestamos;

                ctx.SaveChanges();
            }

            return RedirectToAction("Get", "Clientes");
        }

        public ActionResult Details(int id)
        {
            Clientes c = new Clientes();

            using (BancosEntities ctx = new BancosEntities())
            {
                Clientes edit = ctx.Clientes.Single(x => x.IdCliente == id);

                c.IdCliente = edit.IdCliente;
                c.NifNie = edit.NifNie;
                c.Nombre = edit.Nombre;
                c.Operaciones = edit.Operaciones;
                c.Prestamos = edit.Prestamos;
                c.Apellidos = edit.Apellidos;
                c.Cuentas = edit.Cuentas;
            }

            return View(c);
        }

        public ActionResult Operations(int id)
        {
            List<Operaciones> list = new List<Operaciones>();
            BancosEntities ctx = new BancosEntities();

            list = ctx.Operaciones.Where(p => p.IdCliente == id).ToList();

            return View(list);


        }
    }
}