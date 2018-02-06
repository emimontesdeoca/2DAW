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
        List<Product> lista = new List<Product>();

        // GET: Product
        public ActionResult Index()
        {

            return View(model: getProductos());
        }

        public List<Product> getProductos()
        {

            for (int i = 0; i < 10; i++)
            {
                Product p = new Product(i, "Producto " + i, "Categoria " + i);
                lista.Add(p);
            }

            return lista;
        }


    }
}