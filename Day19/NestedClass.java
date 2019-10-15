class CheckPassword{
	@SuppressWarnings("unused")
	private int i;
	private class PasswordDecrypt{
		@SuppressWarnings("unused")
		private int j=200;
		void decryptionDone() {
			System.out.println("Decrpytion Done");
		}
	}
	public void display() {
		PasswordDecrypt decrypt=new PasswordDecrypt();
		decrypt.decryptionDone();
	}
	class PasswordEncrypt{
		void encryptionDone() {
			System.out.println("Encryption Done");
		}
	}
}
public class NestedClass {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CheckPassword checkPassword=new CheckPassword();
		checkPassword.display();
		CheckPassword.PasswordEncrypt encrypt=checkPassword.new PasswordEncrypt();
		encrypt.encryptionDone();
	

	}

}
