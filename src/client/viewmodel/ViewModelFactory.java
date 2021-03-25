package client.viewmodel;

import client.model.Model;

public class ViewModelFactory {
    private ChatViewModel chatViewModel;
    private LoginViewModel loginViewModel;
    private LogViewModel logViewModel;
    private RegisterViewModel registerViewModel;
    public ViewModelFactory(Model model){
        this.chatViewModel = new ChatViewModel(model);
        this.loginViewModel = new LoginViewModel(model);
        this.logViewModel = new LogViewModel(model);
        this.registerViewModel = new RegisterViewModel(model);
    }

    public ChatViewModel getChatViewModel() {
        return chatViewModel;
    }

    public LoginViewModel getLoginViewModel() {
        return loginViewModel;
    }

    public LogViewModel getLogViewModel() {
        return logViewModel;
    }

    public RegisterViewModel getRegisterViewModel(){
        return registerViewModel;}
}
