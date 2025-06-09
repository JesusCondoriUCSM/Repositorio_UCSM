package graph;

public class VertexObj<V,E>{
	protected V info;
	protected int position;
	
	public VertexObj(V info, int position){
		this.info = info;
		this.position = position;
	}
	public V getInfo() {
	    return info;
	}

	public void setInfo(V info) {
	    this.info = info;
	}

	public int getPosition() {
	    return position;
	}

	public void setPosition(int position) {
	    this.position = position;
	}

	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;
	    VertexObj<?, ?> that = (VertexObj<?, ?>) o;
	    return info.equals(that.info);
	}

}
