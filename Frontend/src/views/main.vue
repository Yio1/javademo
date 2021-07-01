<template>
  <div class="out">
    <el-table
      :data="tableData"
      :row-class-name="highlightRow"
      highlight-current-row
      @current-change="focusRow"
    >
      <el-table-column prop="sid" label="学生编号" width="100">
      </el-table-column>
      <el-table-column prop="sname" label="学生姓名" width="100">
      </el-table-column>
      <el-table-column prop="sno" label="学号" width="100"> </el-table-column>
      <el-table-column prop="gradeid" label="年级" width="100">
      </el-table-column>
      <el-table-column prop="address" label="地址" width="100">
      </el-table-column>
      <el-table-column prop="score" label="分数" width="150"> </el-table-column>
      <el-table-column prop="password" label="密码" width="100">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="收货地址" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="学生编号" :label-width="formLabelWidth">
          <el-input v-model="form.sid" autocomplete="off" disabled></el-input>
        </el-form-item>

        <el-form-item label="学生姓名" :label-width="formLabelWidth">
          <el-input v-model="form.sname" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="学号" :label-width="formLabelWidth">
          <el-input v-model="form.sno" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="地址" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="分数" :label-width="formLabelWidth">
          <el-input v-model="form.score" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.password" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false"
          >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      tableData: [
        {
          sid: 1,
          sname: "小叶",
          sno: "1001",
          gradeid: 1,
          address: "北京",
          score: 90,
          password: 123,
        },
        {
          sid: 2,
          sname: "小明",
          sno: "1002",
          gradeid: 1,
          address: "香港",
          score: 90,
          password: 123,
        },
        {
          sid: 3,
          sname: "小王",
          sno: "1002",
          gradeid: 3,
          address: "香港",
          score: 91,
          password: 123,
        },
        {
          sid: 4,
          sname: "小常",
          sno: "1003",
          gradeid: 2,
          address: "曹县",
          score: 101,
          password: 123,
        },
      ],
      currentRow: null,
      dialogFormVisible: false,
      form: {
        sid: "",
        sname: "",
        sno: "",
        gradeid: "",
        address: "",
        score: "",
        password: "",
      },
      formLabelWidth: "100px",
    };
  },
  methods: {
    highlightRow(data) {
      let row = data.row;
      if (row.gradeid == 1) {
        return "online-row";
      } else if (row.gradeid == 2) {
        return "offline-row";
      } else {
        return "warning-row";
      }
    },
    focusRow(data) {
      this.currentRow = data;
    },
    handleEdit(index, row) {
      console.log(index, row);
      this.form = row;
      this.dialogFormVisible = true;
    },
    handleDelete(index, row) {
      console.log(index, row);
    },
  },
  beforeMount() {
    // console.log(this.$route.params);
  },
};
</script>

<style scoped>
.el-table >>> .online-row {
  display: relative;
  background-color: #e1f3d8;
}
.el-table >>> .online-row ::before {
  transition: all 0.5s;
  display: block;
  content: "";
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(225, 243, 216, 0%);
  pointer-events: none;
}
.el-table >>> .offline-row {
  display: relative;
  background-color: #e9e9eb;
}
.el-table >>> .offline-row ::before {
  transition: all 0.5s;
  display: block;
  content: "";
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(233, 233, 235, 0%);
  pointer-events: none;
}
.el-table >>> .warning-row {
  display: relative;
  background-color: #fde2e2;
}
.el-table >>> .warning-row ::before {
  transition: all 0.5s;
  display: block;
  content: "";
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
  height: 100%;
  background: rgba(253, 226, 226, 0%);
  pointer-events: none;
}
.el-table >>> .current-row ::before {
  transition: all 0.5s;
  background: rgba(0, 0, 0, 10%);
  pointer-events: none;
}
.el-table >>> td {
  background-color: initial !important;
}
.el-table >>> .el-button::before {
  background: rgba(0, 0, 0, 0%);
}
.el-table >>> span::before {
  background: rgba(0, 0, 0, 0%) !important;
}
</style>
