package com.imcore.x_bionic.Activity.downimage;
//package com.imcore.ymea.downimage;
//
//import java.io.File;
//import java.lang.ref.WeakReference;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.AsyncTask;
//import android.os.Environment;
//import android.widget.ImageView;
//
//import com.imcore.ymtea.R;
//
//
//
///**
// * ���ر���ͼƬ��ָ����ImageView�ؼ������첽�ķ�ʽ4��ȡͼƬ������
// * 
// * @author Li Bin
// */
//public class ImageWorker {
//	public static final File APP_DIR = new File(
//			Environment.getExternalStorageDirectory(), "demo");
//
//	/**
//	 * ��ָ��·����ͼƬ����ʾ��ָ����ImageView�ؼ���
//	 * 
//	 * @param path
//	 * @param view
//	 */
//	public void fetch(String path, ImageView view) {
//		ImageFetchTask task = null;
//		// ImageView��tag���Ϊ�գ�˵������һ�����õĿؼ�
//		if (view.getTag() != null) {
//			task = ((WeakReference<ImageFetchTask>) view.getTag()).get();
//			if (task != null) {
//				// ������ã�����ʾͼƬ
//				view.setImageBitmap(null);
//			}
//		}
//
//		task = new ImageFetchTask(view);
//		WeakReference<ImageFetchTask> wrTask = new WeakReference<ImageWorker.ImageFetchTask>(
//				task);
//		view.setTag(wrTask);
//		task.execute(path);
//	}
//
//	/**
//	 * �첽����ͼƬ���첽����
//	 */
//	class ImageFetchTask extends AsyncTask<String, Void, Bitmap> {
//		private WeakReference<ImageView> mWeakImageView;
//
//		public ImageFetchTask(ImageView view) {
//			mWeakImageView = new WeakReference<ImageView>(view);
//		}
//
//		@Override
//		protected Bitmap doInBackground(String... params) {
//			String path = params[0];
//			Bitmap bm = ImageCache.getInstance().get(path);
//			if (mWeakImageView.get() != null) {
//				if (bm == null) {
//					ImageView imageView = mWeakImageView.get();
//					Context ctx = imageView.getContext();
//
//					int pxWidth = imageView.getWidth();
//					int pxHeight = imageView.getHeight();
//
//					int reqWidth = DisplayUtil.px2Dip(ctx, pxWidth);
//					int reqHeight = DisplayUtil.px2Dip(ctx, pxHeight);
//					bm = getBitmapByFilePath(path, reqWidth, reqHeight);
//					ImageCache.getInstance().put(path, bm);
//				}
//			}
//			return bm;
//		}
//
//		protected void onPostExecute(Bitmap result) {
//			ImageView imageView = mWeakImageView.get();
//			if (imageView != null) {
//				if (result != null) {
//					imageView.setImageBitmap(result);
//				} else {
//					imageView.setImageResource(R.drawable.ic_launcher);
//				}
//			}
//		}
//	}
//
//	/**
//	 * ��ָ�����ļ�·������ȡͼƬ��Ϣ����ΪBitmap���󷵻�
//	 * 
//	 * @param path
//	 *            ͼƬ·��
//	 * @param reqWidth
//	 *            ��Ҫ��ͼƬ���
//	 * @param reqHeight
//	 * @return
//	 */
//	public Bitmap getBitmapByFilePath(String path, int reqWidth, int reqHeight) {
//		BitmapFactory.Options opts = new BitmapFactory.Options();
//
//		File file = new File(APP_DIR,String.valueOf(path.hashCode()));
//		
//		// ���õ�ǰֻ����ͼƬ�Ŀ�ߵȱ߽���Ϣ,������ͼƬ��������
//		opts.inJustDecodeBounds = true;
//		// �Ѷ�ȡ����ͼƬ�Ŀ�ߵ���Ϣ����opts
//		BitmapFactory.decodeFile(file.getAbsolutePath(), opts);
//
//		// ������ű�
//		opts.inSampleSize = calculateInSampleSize(opts, reqWidth, reqHeight);
//		// ����ͼƬ���
//		opts.inJustDecodeBounds = false;// Ϊɶ�㶮��
//		Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath(),
//				opts);
//
//		return bm;
//	}
//
//	private int calculateInSampleSize(BitmapFactory.Options options,
//			int reqWidth, int reqHeight) {
//		final int height = options.outHeight;
//		final int width = options.outWidth;
//		int inSampleSize = 1;
//
//		if (height > reqHeight || width > reqWidth) {
//			final int heightRatio = Math.round((float) height
//					/ (float) reqHeight);
//			final int widthRatio = Math.round((float) width / (float) reqWidth);
//			inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
//
//			final float totalPixels = width * height;
//			final float totalReqPixelsCap = reqWidth * reqHeight * 2;
//			while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
//				inSampleSize++;
//			}
//		}
//		return inSampleSize;
//	}
//
//}
