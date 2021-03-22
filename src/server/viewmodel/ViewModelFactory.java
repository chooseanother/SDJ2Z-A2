package server.viewmodel;

import server.model.Model;

public class ViewModelFactory {
    private ChatViewModel chatViewModel;
    private LoginViewModel loginViewModel;
    private LogViewModel logViewModel;
    public ViewModelFactory(Model model){
        this.chatViewModel = new ChatViewModel(model);
        this.loginViewModel = new LoginViewModel(model);
        this.logViewModel = new LogViewModel(model);
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
}
