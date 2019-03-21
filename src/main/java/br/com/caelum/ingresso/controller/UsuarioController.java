package br.com.caelum.ingresso.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.mail.EmailNovoUsuario;
import br.com.caelum.ingresso.mail.Mailer;
import br.com.caelum.ingresso.mail.TokenHelper;
import br.com.caelum.ingresso.model.Token;
import br.com.caelum.ingresso.model.form.ConfirmacaoLoginForm;

@Controller
public class UsuarioController {

	@Autowired
	private Mailer mailer;
	@Autowired
	private TokenHelper tokenHelper;

	@GetMapping("/usuario/request")
	public ModelAndView formSolicitacaoDeAcesso() {
		return new ModelAndView("usuario/form-email");
	}

	@PostMapping("/usuario/request")
	public ModelAndView solicitacaoDeAcesso(String email) {
		ModelAndView view = new ModelAndView("usuario/adicionado");

		Token token = tokenHelper.generateFrom(email);
		mailer.send(new EmailNovoUsuario(token));

		return view;
	}

	@GetMapping("/usuario/validate")
	public ModelAndView validaLink(@RequestParam("uuid") String uuid) {
		Optional<Token> optionalToken = tokenHelper.getTokenFrom(uuid);
		if (!optionalToken.isPresent()) {
			ModelAndView view = new ModelAndView("redirect:/login");
			view.addObject("msg",
					"O	token	do	link	utilizado	não	foi	encontrado!");
			return view;
		}
		
		Token token	=	optionalToken.get();
		ConfirmacaoLoginForm	confirmacaoLoginForm	=	new	ConfirmacaoLoginForm(token);
		ModelAndView	view	=	new	ModelAndView("usuario/confirmacao");
		view.addObject("confirmacaoLoginForm",	confirmacaoLoginForm);
		return	view;
	}
	
	@PostMapping("/usuario/cadastrar")
	public	ModelAndView	cadastrar(ConfirmacaoLoginForm	form){
					ModelAndView	view	=	new	ModelAndView("redirect:/login");
					if	(	form.isValid()	)	{
									//	Salvar	usuário	no	banco
					}
					view.addObject("msg",	"O	token	do	link	utilizado	não	foi	encontrado!");
					return	view;
	}
}
