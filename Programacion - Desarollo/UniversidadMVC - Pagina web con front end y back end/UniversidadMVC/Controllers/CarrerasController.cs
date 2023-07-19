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
using Microsoft.Data.SqlClient;

namespace UniversidadMVC.Controllers
{
    public class CarrerasController : Controller
    {

        private readonly UniversidadDbContext _context;

        public CarrerasController(UniversidadDbContext context)
        {
            _context = context;
        }

        [Authorize(Roles = "Administrador")]
        public IActionResult Index()
        {
            return View();
        }
        [Authorize(Roles = "Administrador")]
        public IActionResult CrearCarrera()
        {
            return View();
        }
        [Authorize(Roles = "Administrador")]
        public IActionResult BorrarCarrera()
        {
            return View();
        }
        [Authorize(Roles = "Administrador,ElUsuario")]
        public IActionResult Grilla()
        {
            var carreras = _context.Carreras.ToList();
            return View(carreras);
        }

        //Crea carreras
        [Authorize(Roles = "Administrador")]
        public async Task<IActionResult> CrearCarreras([Bind("Nombre")] NuevaCarrera otraCarrera)
        {
            Carrera nuevaCategoria = new Carrera();
            nuevaCategoria.Nombre = otraCarrera.Nombre;
            var datosTabla = await _context.Carreras.FirstOrDefaultAsync(m => m.Nombre == otraCarrera.Nombre);

            if (datosTabla == null)
            {
                await _context.Carreras.AddAsync(nuevaCategoria);
                await _context.SaveChangesAsync();
            }
            return RedirectToAction(nameof(Index));
        }


        //Borra Carreras por ID
        [Authorize(Roles = "Administrador")]
        public async Task<IActionResult> BorrarCarreraId([Bind("Id")] NuevaCarrera borrarId)
        {
            if (_context.Carreras == null)
            {
                return Problem("Entity set 'UniversidadDbContext.Carreras'  is null.");
            }

            var carrera = await _context.Carreras.FindAsync(borrarId.Id);

            if (carrera != null)
            {
                _context.Carreras.Remove(carrera);
            }

            await _context.SaveChangesAsync();

            return RedirectToAction(nameof(Index));
        }


        //Borra Carreras por Nombre
        [Authorize(Roles = "Administrador")]
        public async Task<IActionResult> BorrarCarreraNombre([Bind("Nombre")] NuevaCarrera borrarNombre)
        {
            if (_context.Carreras == null)
            {
                return Problem("Entity set 'UniversidadDbContext.Carreras'  is null.");
            }

            var carrera = await _context.Carreras.FirstOrDefaultAsync(m => m.Nombre == borrarNombre.Nombre);

            if (carrera != null)

            {

                _context.Carreras.Remove(carrera);
            }

            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

    }
}

