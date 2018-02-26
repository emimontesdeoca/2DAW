using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace BancosEMontesdeoca.Filters
{
    public class AdminFilter : ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext filterContext)
        {
            BancoUsers u = null;

            if (filterContext.HttpContext.Session["usuario"] is BancoUsers)
            {
                u = filterContext.HttpContext.Session["usuario"] as BancoUsers;
            }



            if (u == null || !u.Grupos.Contains("ADMIN"))
            {
                FormsAuthentication.SignOut();
                filterContext.HttpContext.Session.Abandon();
                filterContext.HttpContext.Session.Clear();

                filterContext.Result = new ViewResult()
                {
                    ViewName = "AuthError"
                };

            }
        }
    }
}