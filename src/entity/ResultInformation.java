package entity;

import java.util.List;

public class ResultInformation {
    /**
     * error_code : 0
     * error_msg : SUCCESS
     * log_id : 304569293927165821
     * timestamp : 1569392716
     * cached : 0
     * result : {"face_num":1,"face_list":[{"face_token":"437048e220465b3a0d4bdcc766e56410","location":{"left":177.77,"top":100.96,"width":120,"height":124,"rotation":-7},"user_list":[{"group_id":"homework","user_id":"test1_1","user_info":"","score":94.508377075195}]}]}
     */

    private int error_code;
    private String error_msg;
    private long log_id;
    private int timestamp;
    private int cached;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getCached() {
        return cached;
    }

    public void setCached(int cached) {
        this.cached = cached;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * face_num : 1
         * face_list : [{"face_token":"437048e220465b3a0d4bdcc766e56410","location":{"left":177.77,"top":100.96,"width":120,"height":124,"rotation":-7},"user_list":[{"group_id":"homework","user_id":"test1_1","user_info":"","score":94.508377075195}]}]
         */

        private int face_num;
        private List<FaceListBean> face_list;

        public int getFace_num() {
            return face_num;
        }

        public void setFace_num(int face_num) {
            this.face_num = face_num;
        }

        public List<FaceListBean> getFace_list() {
            return face_list;
        }

        public void setFace_list(List<FaceListBean> face_list) {
            this.face_list = face_list;
        }

        public static class FaceListBean {
            /**
             * face_token : 437048e220465b3a0d4bdcc766e56410
             * location : {"left":177.77,"top":100.96,"width":120,"height":124,"rotation":-7}
             * user_list : [{"group_id":"homework","user_id":"test1_1","user_info":"","score":94.508377075195}]
             */

            private String face_token;
            private LocationBean location;
            private List<UserListBean> user_list;

            public String getFace_token() {
                return face_token;
            }

            public void setFace_token(String face_token) {
                this.face_token = face_token;
            }

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public List<UserListBean> getUser_list() {
                return user_list;
            }

            public void setUser_list(List<UserListBean> user_list) {
                this.user_list = user_list;
            }

            public static class LocationBean {
                /**
                 * left : 177.77
                 * top : 100.96
                 * width : 120
                 * height : 124
                 * rotation : -7
                 */

                private double left;
                private double top;
                private int width;
                private int height;
                private int rotation;

                public double getLeft() {
                    return left;
                }

                public void setLeft(double left) {
                    this.left = left;
                }

                public double getTop() {
                    return top;
                }

                public void setTop(double top) {
                    this.top = top;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getRotation() {
                    return rotation;
                }

                public void setRotation(int rotation) {
                    this.rotation = rotation;
                }
            }

            public static class UserListBean {
                /**
                 * group_id : homework
                 * user_id : test1_1
                 * user_info :
                 * score : 94.508377075195
                 */

                private String group_id;
                private String user_id;
                private String user_info;
                private double score;

                public String getGroup_id() {
                    return group_id;
                }

                public void setGroup_id(String group_id) {
                    this.group_id = group_id;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }

                public String getUser_info() {
                    return user_info;
                }

                public void setUser_info(String user_info) {
                    this.user_info = user_info;
                }

                public double getScore() {
                    return score;
                }

                public void setScore(double score) {
                    this.score = score;
                }
            }
        }
    }
}
