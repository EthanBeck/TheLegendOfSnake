package MainHandler;

import KeyboardAction.Keys;

public class Main implements Runnable
{
	int ticks;
	int frames;
	public static final int FRAMES_PER_SECOND =40;
	static Screen screen;
	
	public static void main(String args[])
	{
		screen = new Screen();
		new Main().run();
	}
    public void tick()
    {
    }
	private synchronized void start(){
		new Thread(this).start();
	}
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/FRAMES_PER_SECOND;
		
		ticks = 0;
		frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while(true){
			long now = System.nanoTime();
			delta+=(now-lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while(delta>=1){//Checks number of frames per second
				if(ticks%1==0)
					tick();
				ticks++;
				delta-=1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(shouldRender){
				frames++;
			}

			if(System.currentTimeMillis()-lastTimer >= 1000){//Per second here
				lastTimer +=1000;
				frames = 0;
				ticks = 0;
			}
		}
	}
}
