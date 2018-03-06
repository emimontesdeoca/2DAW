using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace BancosEMontesdeoca.Filters
{
    public class ManagerFilter : ActionFilterAttribute
    {
        /// <summary>
        /// Metodo para cargar el filtro
        /// </summary>
        /// <param name="filterContext"></param>
        public override void OnActionExecuting(ActionExecutingContext filterContext)
        {
            /// Usuario a cargar
            BancoUsers u = null;

            /// Recoger el session
            u = filterContext.HttpContext.Session["usuario"] as BancoUsers;


            /// Si es nulo o no contiene MANAGEMENT en el grupo no vale
            if (u == null || !u.Grupos.Contains("MANAGEMENT"))
            {
                /// Limpiar cookes, session y login
                FormsAuthentication.SignOut();
                filterContext.HttpContext.Session.Abandon();
                filterContext.HttpContext.Session.Clear();

                /// Retornar a vista de error de autenticacion
                filterContext.Result = new ViewResult()
                {
                    ViewName = "AuthError"
                };

            }
        }
    }
}