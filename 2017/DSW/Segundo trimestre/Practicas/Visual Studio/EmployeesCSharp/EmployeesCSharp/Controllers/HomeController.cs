using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EmployeesCSharp.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            //ContentResult res = new ContentResult();
            //res.Content = "Hola mundo!";
            //return res;
            return View();
        }

        public String Index2(int id)
        {

            return "Index 2, id=" + id;
        }
    }
}