package Helper;


import javax.swing.JOptionPane;


import javax.swing.UIManager;

public class Helper {

	public static void optionPaneChangeButtonText() {
		UIManager.put("OptionPane.cancelButtontext", "İptal");
		UIManager.put("OptionPane.noButtontext", "Hayır");
		UIManager.put("OptionPane.okButtontext", "Tamam");
		UIManager.put("OptionPane.yesButtontext", "Evet");

	}
	
	public static void showMsg(String str) {
		String msg;
		optionPaneChangeButtonText();
		switch(str) {
		case "fill":
			msg = "Lütfen tüm alanları doldurunuz.";
			break;
		case "success":	
			msg = "İşlem Başarılı.";
			break;
		case "error":
			msg = "Bir hata gerçekleşti";
			break;
		default:
			msg = str;
		}
		
		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static boolean confirm(String str) {
		String msg;
		optionPaneChangeButtonText();
		switch(str) {
		case "sure":
			msg = "Bu işlemi gerçekleştirmek istiyor musunuz?";
			break;
			default:
				msg = str;
				break;
		}
	
		int res = JOptionPane.showConfirmDialog(null, msg, "Dikkat!", JOptionPane.YES_NO_OPTION);
		
		if(res == 0) {
			return true;
		}else {
			return false;
		}
	}


}