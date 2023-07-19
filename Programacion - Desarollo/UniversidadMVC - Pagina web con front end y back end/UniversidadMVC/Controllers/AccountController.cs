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
    public class AccountController : Controller
    {

        private UserManager<Usuario> _userMgr { get; }
        private SignInManager<Usuario> _signInMgr { get; }
        private RoleManager<Role> _role { get; }

        public static string cosaAbstracta { get; set; }

        private readonly UniversidadDbContext _context;

        public AccountController(UniversidadDbContext context, UserManager<Usuario> userManager, SignInManager<Usuario> signInMgr, RoleManager<Role> role)
        {
            _userMgr = userManager;
            _context = context;
            _signInMgr = signInMgr;
            _role = role;
        }

        public IActionResult Index()
        {
            return View();
        }
       
        public IActionResult LogIn()
        {
            return View();
        }

        public IActionResult Register()
        {
            return View();
        }
        [Authorize(Roles = "ElUsuario")]
        public IActionResult RegistrarseEnMaterias()
        {
            return View();
        }

 
        //Codigo Registrarse
        public async Task<IActionResult> Registrarse([Bind("UserName,Name,LastName,PasswordRegister")] Registrar userForm)
        {
            //Si se puede, usar en el constructor.
            Usuario user = new Usuario();
            string passwordAdmin = "12345Abc@";

            Role administrador = new Role();
            administrador.Name = "Administrador";
            await _role.CreateAsync(administrador);

            Role usuario = new Role();
            usuario.Name = "ElUsuario";
            await _role.CreateAsync(usuario);

            Usuario segundo = await _userMgr.FindByNameAsync(userForm.UserName);

            if (segundo == null && userForm.PasswordRegister.Equals(passwordAdmin))
            {

                user = new Usuario();
                user.UserName = userForm.UserName;

                
                await _userMgr.CreateAsync(user, userForm.PasswordRegister);
                IdentityResult result = await _userMgr.AddToRoleAsync(user, "Administrador");

                if (result.Succeeded)
                {
                    //Redireccion
                    return RedirectToAction("Index", "Home");
                }
            }

            if(segundo == null && !userForm.PasswordRegister.Equals(passwordAdmin))
            {

                user = new Usuario();
                user.UserName = userForm.UserName;

                
                await _userMgr.CreateAsync(user, userForm.PasswordRegister);
                IdentityResult resultado2 = await _userMgr.AddToRoleAsync(user, "ElUsuario");

                if (resultado2.Succeeded)
                {

                    return RedirectToAction("Index", "Home");

                }

            }
            
        return RedirectToAction("Error", "Home");

        }

        //Codigo Login

        public async Task<IActionResult> Entrar([Bind("UserName,Password")] Loguearse _logIn)
        {
            //En caso de que no te puedas inscribir a materias, moverlo aca arriba.
           // cosaAbstracta = _logIn.UserName;

            Microsoft.AspNetCore.Identity.SignInResult result = await _signInMgr.PasswordSignInAsync(_logIn.UserName, _logIn.Password, false, false);
            IList<string> rol = await _userMgr.GetRolesAsync(new Usuario());
            if (result.Succeeded)
            {

                cosaAbstracta = _logIn.UserName;
                return RedirectToAction("Index", "Home");
            }
            return RedirectToAction("Privacy", "Home");

        }
       
        //Permite que el usuario se inscriba a las materias

        [Authorize(Roles = "ElUsuario")]
        public async Task<IActionResult> InscribirseMaterias([Bind("Nombre")] NuevaCarrera buscarCarrera)
        {
            if (_context.Carreras == null)
            {
                return Problem("Entity set 'UniversidadDbContext.Carreras' is null.");
            }

            var carreraEncontrada = await _context.Carreras.Include(c => c.Materias).FirstOrDefaultAsync(m => m.Nombre == buscarCarrera.Nombre);

            if (carreraEncontrada != null)
            {
                var miercoles = await _userMgr.FindByNameAsync(cosaAbstracta);

                if (miercoles != null)
                {
                    if (miercoles.Inscripciones == null)
                    {
                        miercoles.Inscripciones = new List<Inscripcion>();
                    }

                    Inscripcion nuevaInscripcion = new Inscripcion();

                    if (carreraEncontrada.Materias != null)
                    {
                        nuevaInscripcion.Materias = carreraEncontrada.Materias.ToList();
                    }
                    else
                    {
                        return RedirectToAction("Privacy", "Home");
                       
                    }

                    miercoles.Inscripciones.Add(nuevaInscripcion);

                    await _context.SaveChangesAsync();

                    return RedirectToAction(nameof(Index));

                }

                return RedirectToAction("Privacy", "Home");
            }

             return RedirectToAction("Privacy", "Home");
        }

    }
}


