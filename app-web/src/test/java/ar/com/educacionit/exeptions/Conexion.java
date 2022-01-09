package ar.com.educacionit.exeptions;

public class Conexion {
	
	private boolean open;
	private boolean err;
	
	public void open() throws ConnectionIsAlreadyOpenExeption {
		if (open) {
			throw new ConnectionIsAlreadyOpenExeption();
		} else {
			open = true;
		}
	}
	
	public void close() throws ConnectionIsNotOpenException {
		if (!open) {
			throw new ConnectionIsNotOpenException();
		} else {
			open = false;
		}
			
	}
	
	public void commit() {
		
		if (!open) {
			throw new CommitExeption("Error: connection close");
		}
		
		if (err) {
			throw new CommitExeption("Error: ");
		}
		
		System.out.println("Commiting changes");
	}
	
	public void rollback() {
		
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isErr() {
		return err;
	}

	public void setErr(boolean err) {
		this.err = err;
	}

}
