package server.view;

import javafx.event.ActionEvent;

public class RegisterViewController extends ViewController
{
  @Override protected void init()
  {
    
  }

  public void onBack(ActionEvent actionEvent)
  {
    getViewHandler().openView(View.LOGIN);
  }

  public void onRegister(ActionEvent actionEvent)
  {
    getViewHandler().openView(View.LOGIN);
  }
}
