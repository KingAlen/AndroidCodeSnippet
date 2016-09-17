/**
 * @date 16/9/17
 * @author AllenKK
 * @Description Drop Down a View and Drop up
 * @version 1.0
 */

/**
  * Drop down and up entrance
  * @param animationView The view which will do animation
  * @param originHeight The view's normal height
  * @param down  true if drop down, otherwise drop up
  */
public void dropDownAndUp(View animationView, int originHeight, boolean down) {
    if (down) {
        animateDown(animationView, origHeight);
    } else {
        animateUp(animationView, origHeight);
    }
}

private void animateDown(View view, int origHeight) {
    ValueAnimator animator = getDropAnimator(view, 0, origHeight);
    animator.start();
}

private void animateUp(View view, int origHeight) {
    ValueAnimator animator = getDropAnimator(view, origHeight, 0);
    animator.start();
}

private ValueAnimator getDropAnimator(View view, int start, int end) {
    ValueAnimator animator = ValueAnimator.ofInt(start, end);
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int value = (Integer) valueAnimator.getAnimatedValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = value;
            view.setLayoutParams(layoutParams);
        }
    });
    return animator;
}