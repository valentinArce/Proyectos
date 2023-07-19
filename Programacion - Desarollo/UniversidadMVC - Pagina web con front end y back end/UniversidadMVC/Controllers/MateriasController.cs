using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using NuGet.Protocol.Plugins;
using System.Data;
using System.Drawing.Drawing2D;
using System.Linq;
using UniversidadMVC.Data;
using UniversidadMVC.Models;
using System.Web;

namespace UniversidadMVC.Controllers
{
    public class MateriasController : Controller
    {

        private readonly UniversidadDbContext _context;

        public MateriasController(UniversidadDbContext context)
        {
            _context = context;
        }

        [Authorize(Roles = "Administrador")]
        public IActionResult AgregarMaterias()
        {
            return View();
        }
        public IActionResult Index()
        {
            return View();
        }

        //Codigo para Agregar Materias a las Carreras
        [Authorize(Roles = "Administrador")]
        public async Task<IActionResult> AgregarMateria([Bind("Carrera,Nombre")] MateriasParaAgregar materias)
        {
            Materia materiaFalsa = new Materia();
            materiaFalsa.Nombre = materias.Nombre;

            Carrera carreraFalsa = new Carrera();
            carreraFalsa.Nombre = materias.Carrera;

            var datosTabla = await _context.Carreras.FirstOrDefaultAsync(m => m.Nombre.Equals(carreraFalsa.Nombre));

            if (datosTabla != null)
            {
                if (datosTabla.Materias == null)
                {
                    datosTabla.Materias = new List<Materia>();
                }

                datosTabla.Materias.Add(materiaFalsa);
   
                await _context.SaveChangesAsync();

                return RedirectToAction("Index", "Home");
            }

            return RedirectToAction("Error", "Home");
        }

    }

}
