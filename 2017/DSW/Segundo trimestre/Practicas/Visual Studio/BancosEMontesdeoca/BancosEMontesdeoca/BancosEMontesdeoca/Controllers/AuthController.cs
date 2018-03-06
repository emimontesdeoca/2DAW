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
        /// <summary>
        /// Metodo que logea
        /// </summary>
        /// <param name="b">Usuario</param>
        /// <param name="returnUrl">Return url</param>
        /// <returns></returns>
        [HttpPost]
        public ActionResult Login(BancoUsers b, string returnUrl)
        {
            /// Si valida
            if (ModelState.IsValid)
            {
                /// Usuario
                BancoUsers authUser = null;

                /// Conexion a base de datos
                using (BancosEntities ctx = new BancosEntities())
                {
                    try
                    {
                        /// Conseguir usuario
                        authUser = ctx.BancoUsers.First(x => x.Login == b.Login && x.Password == b.Password);

                        /// Guardar cookie
                        FormsAuthentication.SetAuthCookie(authUser.Login, false);

                        /// Guardar session
                        Session["usuario"] = authUser;

                        /// Split para conseguir el returnUrl
                        string[] split = returnUrl.Split('/');

                        /// Retorno al metodo
                        return RedirectToAction(split[2], split[1]);
                    }
                    catch (Exception)
                    {
                        /// Error de credenciales
                        ModelState.AddModelError("CredientalError", "Usuario o contraseña incorrectos");
                        return View();
                    }
                }
            }
            else
            {
                /// No deberia de entrar aqui.
                return View();
            }
        }

        /// <summary>
        /// Funcon de logout
        /// </summary>
        /// <returns></returns>
        public ActionResult Logout()
        {
            /// Limpia todos los campos relacionados con el login
            FormsAuthentication.SignOut();
            Session.Abandon();
            Session.Clear();

            /// Redirigir al Index
            return RedirectToAction("Index", "Home");
        }

    }
}