using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace BancosEMontesdeoca.DataAccesLayer
{
    public class BancosDAL : DbContext
    {
        public DbSet<Clientes> Clientes { get; set; }
        public DbSet<Cuentas> Cuentas { get; set; }
        public DbSet<Entidades> Entidades { get; set; }
        public DbSet<TiposCuenta> TipoCuentas { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Clientes>().ToTable("Clientes");
            modelBuilder.Entity<Cuentas>().ToTable("Cuentas");
            modelBuilder.Entity<Entidades>().ToTable("Entidades");
            modelBuilder.Entity<TiposCuenta>().ToTable("TiposCuenta");
            base.OnModelCreating(modelBuilder);
        }
    }
}