using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace BancosEMontesdeoca.Controllers
{
    [AllowAnonymous]
    public class AuthController : Controller
    {
        // GET: Auth
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login()
        {
            return View();
        }
        [HttpPost]
        public ActionResult Login(BancoUsers b)
        {

            if (ModelState.IsValid)
            {
                BancoUsers authUser = null;

                using (BancosEntities ctx = new BancosEntities())
                {
                    try
                    {
                        authUser = ctx.BancoUsers.First(x => x.Login == b.Login && x.Password == b.Password);
                        FormsAuthentication.SetAuthCookie(authUser.Login, false);
                        Session["usuario"] = authUser;
                        return RedirectToAction("Get", "Cuentas");

                    }
                    catch (Exception)
                    {
                        ModelState.AddModelError("CredientalError", "Usuario o contraseña incorrectos");
                        return View();
                    }
                }
            }
            else
            {
                return View();
            }
        }

        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            Session.Abandon();
            Session.Clear();

            return RedirectToAction("Index", "Home");
        }

    }
}