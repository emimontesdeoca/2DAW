using EmployeesCSharp.Data;
using EmployeesCSharp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EmployeesCSharp.Controllers
{
    public class ProductController : Controller
    {
        static List<Product> lista = new ProductData().GetData();

        // GET: Product
        public ActionResult Index()
        {
            return View(model: getProductos());
        }

        public List<Product> getProductos()
        {
            return lista;
        }

        public ActionResult create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(Product p)
        {

            if (ModelState.IsValid)
            {
                lista.Add(p);

                return RedirectToAction("Index");
            }
            else
            {
                return View();
            }
        }

    }
}